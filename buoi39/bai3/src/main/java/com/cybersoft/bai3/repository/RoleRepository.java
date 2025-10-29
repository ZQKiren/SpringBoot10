package com.cybersoft.bai3.repository;

import com.cybersoft.bai3.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findById(int id);
}
