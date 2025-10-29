package com.cybersoft.bai5.repository;

import com.cybersoft.bai5.entity.User;
import com.cybersoft.bai5.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    void deleteByUser(User user);
}
