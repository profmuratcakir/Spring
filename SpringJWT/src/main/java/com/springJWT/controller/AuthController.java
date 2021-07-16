package com.springJWT.controller;

import com.springJWT.repository.KisiRepository;
import com.springJWT.reqres.MesajResponse;
import com.springJWT.reqres.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    KisiRepository kisiRepository;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        if(kisiRepository.existsByUsername(registerRequest.getUsername())){
            return ResponseEntity
                    .badRequest().
                            body( new MesajResponse("Hata: username kullaniliyor"));

        }


    }

}
