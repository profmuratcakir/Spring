package com.springJWT.reqres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private Long id;
    private String username;
    private String email;
    private List<String> roller;

}
