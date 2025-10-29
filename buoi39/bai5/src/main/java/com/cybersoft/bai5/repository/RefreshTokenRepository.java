package com.cybersoft.bai5.repository;

import com.cybersoft.bai5.entity.RefreshToken;
import com.cybersoft.bai5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    Long deleteByUser(User user);
}
