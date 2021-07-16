package com.springJWT.repository;

import com.springJWT.model.KisiRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<KisiRole, Integer> {
}
