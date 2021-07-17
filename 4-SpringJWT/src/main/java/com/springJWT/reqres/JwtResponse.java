package com.springJWT.reqres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> roller;

    public JwtResponse(String token, Long id, String username, String email, List<String> roller) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roller = roller;
    }
}
