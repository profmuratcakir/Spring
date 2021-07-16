package com.springJWT.repository;

import com.springJWT.model.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KisiRepository extends JpaRepository<Kisi, Long > {
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
