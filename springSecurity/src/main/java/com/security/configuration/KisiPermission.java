package com.security.configuration;

public enum KisiPermission {
    USER_READ("user:read"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    private String permission;

    public String getPermission() {
        return permission;
    }

    KisiPermission (String permission){
        this.permission = permission;
    }

}
