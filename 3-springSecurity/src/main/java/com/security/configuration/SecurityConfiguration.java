package com.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
// METHOD-BASED  AUTH ANOTASYONLARINI ETKİN HALE GETİRİR.
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    //Şifremizi kodlayacak olan encoder'in eklenmesi
    private PasswordEncoder passwordEncoder;

    // SecurityConfiguration classinin constructor
    @Autowired
    public SecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // WebSecurityConfigurerAdapter içerisindeki HTTP securty metodunu override ediyoruz.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll(); // şifreleri devre dışı bıraktık.
        http.
                csrf().disable().       // Cross-Site-Request-Forgery disable yaptık
                authorizeRequests().    // İstekleri denetle
                // Bu uzantılara ve ana sayfa izin şifrsiz girişe izin ver.
                antMatchers("/", "index", "/css/*", "/js/*").permitAll().

                // ==================== ROLE-BASED AUTHENTICATION =====================
                // USER rolune sahip kullanicinin erişebileceği path'in tanımlanmas
//                antMatchers("/kisiler/ara/**").hasRole(KisiRole.USER.name()).
                // ADMIN rolune sahip olan kullanicinin erişebeilceği paty in tanimlanmasi
//                antMatchers("/kisiler/**").hasRole(KisiRole.ADMIN.name()).

                // ==================== METHOD-BASED AUTHENTICATION =====================
                // Metot-tabanlı kimlik denetimi için yapılması gereken adımlar.
                // 1- @EnableGlobalMethodSecurity(prePostEnabled = true) anotasyonunun Security
                //    class'ına konulması gerekir.
                // 2- Rollerin ROLE_ISIM şeklinde tanımlanması gerekir. Bunlar hard-coded olabileceği
                //    gibi KisiRole içerisinde varolan rollerin kullanılmasi ile de olabilir.
                //    Tabi bunun için Enum olan role isimleri ile sabit "ROLE_" kelimesini birleşirecek bir
                //    metot yazmak gerekir.
                // 3- UserDetailService metodu içerisinde kişilerin roles() tanımlamalarını authorities() olarak ,
                //    değiştirmeli ve KisiRole isimlerini ROLE_ISIM şeklinde almak için KisiRole içerisinde yazdığımız
                //    metotu kullanmalıyız.
                // 4- İzinleri ayarlamak için KisiContorller'a giderek metot başına hangi Rollere izin verileceğini
                //    belirlemek gerekmektedir.Bunun için  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                //    anotasyonu kullanılabilir.
                anyRequest().               // tum istekleri
                authenticated().            // Şifreli olarak kullan
                and().                      // VE farklı işmleri birleştirmek için
                httpBasic().and().          // basic http kimlik denetimini kullan
                formLogin().                // form login sayfasi giriş yapılsin

                // === kendi login sayfamızı kullanmak için======
                // 1- Webapp klasöründe yeni login.html sayfası oluşturlur.
               //  2- HomeController içerisinde bir RequestMapping metodu ile path tanımlanır
               //  3- SecurityConfig içerisinde loginPage(/login) metodu ile aktif hale getirilir.
                loginPage("/login").permitAll().
                defaultSuccessUrl("/success").and().
                logout().                       //logout yapılınca şifre vb. bilgileri sil.
                clearAuthentication(true).      // şifrelemeleri sil.
                invalidateHttpSession(true).    // Http oturmunu bitir
                deleteCookies("JESSIONID").     // session id'yi sil
                logoutSuccessUrl("/login");    // logout sonrasında tekrardan login'e yönlendir.
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder().
                username("user").
                password(passwordEncoder.encode("1234")).
//                roles("USER").build();
//                roles(KisiRole.USER.name()).build()
                authorities(KisiRole.USER.otoriteleriAl()).build();

        UserDetails admin1 = User.builder().
                username("admin").
                password(passwordEncoder.encode("5678")).
//                roles("ADMIN").build();                   // Hard-Coded Role tahsisi
//                roles(KisiRole.ADMIN.name()).build();     // Role-based tahsis
                authorities(KisiRole.ADMIN.otoriteleriAl()).build(); // Method-based aut için role tahsis.
        return new InMemoryUserDetailsManager(user1,admin1);
    }
}
