package com.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // WebSecurityConfigurerAdapter içerisindeki HTTP securty metodunu override ediyoruz.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll(); // şifreleri devre dışı bıraktık.
        http.
                authorizeRequests().    // İstekleri denetle
                anyRequest().           // tum istekleri
                authenticated().        // Şifreli olarak kullan
                and().                  // VE farklı işmleri birleştirmek için
                formLogin().            // form login sayfasi giriş yapılsin
                and().                  // VE farklı işmleri birleştirmek için
                httpBasic();            // basic http kimlik denetimini kullan
    }
}
