package com.security.configuration;
import com.google.common.collect.Sets;

import static com.security.configuration.KisiPermission.*;
import java.util.Set;

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
}
