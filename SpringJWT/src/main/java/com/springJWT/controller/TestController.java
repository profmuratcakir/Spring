package com.springJWT.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/all")
    public String allAccess(){
        return "Herkese açık içerik";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_MODERATOR')")
    public String userAccess(){
        return "Yalnızca kayitli kişilere ait içerik";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole( 'ROLE_MODERATOR')")
    public String modAccess(){
        return "Yalnızca Moderator'a ait içerik";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole( 'ROLE_ADMIN')")
    public String adminAccess(){
        return "Yalnızca Admine ait içerik";
    }
}
