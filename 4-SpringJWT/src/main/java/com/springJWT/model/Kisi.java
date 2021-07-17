package com.springJWT.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="personel")
public class Kisi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max=30)
    private String username;

    @NotBlank
    @Size(min=6, max=120)
    private String password;

    @NotBlank
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="kisi_roller", joinColumns = @JoinColumn(name="kisi_id"),
                                    inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<KisiRole> roller = new HashSet<>();

    public Kisi(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
