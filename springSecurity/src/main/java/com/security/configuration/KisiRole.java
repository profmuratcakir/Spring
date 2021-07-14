package com.security.configuration;
import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static com.security.configuration.KisiPermission.*;
import java.util.Set;
import java.util.stream.Collectors;

public enum KisiRole {

    USER(Sets.newHashSet(USER_READ)),
    ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE));

    private Set<KisiPermission> kisiPermission;

    public Set<KisiPermission> getKisiPermission() {
        return kisiPermission;
    }
    KisiRole(Set<KisiPermission> kisiPermission){
        this.kisiPermission = kisiPermission;
    }

    // method-based authenteication işlemi için rolebirleştirme metodu
    public Set<SimpleGrantedAuthority> otoriteleriAl(){
        // Kisi'nin  izinlerinleri alıp SimpleGrantedAuthority class'ına çevirerek permission adında
        // bir Set'e kaydettik.
        Set <SimpleGrantedAuthority> permission = getKisiPermission().
                stream().
                map(x -> new SimpleGrantedAuthority(x.getPermission())).
                collect(Collectors.toSet());

        // permission Set'i içerisindeki iznileri "ROLE_" sabit kelimesi ile birleştirir.
        permission.add( new SimpleGrantedAuthority("ROLE_" + this.name()));
        return  permission;
    }
}
