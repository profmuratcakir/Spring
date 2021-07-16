package com.springJWT.repository;

import com.springJWT.model.ERoller;
import com.springJWT.model.KisiRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<KisiRole, Integer> {
      Optional<KisiRole> findByName(ERoller name);
 }
