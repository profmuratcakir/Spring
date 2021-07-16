package com.springJWT.reqres;

import com.springJWT.model.KisiRole;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
public class RegisterRequest {
    @NotBlank
    private String username;
    @NotBlank
    @Size(min=6, max=40)
    private String password;
    private String email;
    private Set<String> role;

}
