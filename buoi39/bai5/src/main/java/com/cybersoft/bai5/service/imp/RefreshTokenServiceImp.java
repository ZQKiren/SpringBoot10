package com.cybersoft.bai5.service.imp;

import com.cybersoft.bai5.entity.RefreshToken;
import com.cybersoft.bai5.entity.User;
import com.cybersoft.bai5.exception.AuthenticationException;
import com.cybersoft.bai5.repository.RefreshTokenRepository;
import com.cybersoft.bai5.request.RefreshTokenRequest;
import com.cybersoft.bai5.response.AuthTokensResponse;
import com.cybersoft.bai5.service.RefreshTokenService;
import com.cybersoft.bai5.util.JWTHelper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImp implements RefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private JWTHelper jwtHelper;

    @Value("${security.refresh-token.days:7}")
    private long refreshDays;

    @Override
    @Transactional
    public RefreshToken issueFor(User user) {

        refreshTokenRepository.deleteByUser(user);

        RefreshToken rt = new RefreshToken();
        rt.setUser(user);
        rt.setToken(UUID.randomUUID().toString());
        rt.setExpiryDate(LocalDateTime.now().plusDays(refreshDays));

        return refreshTokenRepository.save(rt);
    }

    @Override
    public void revokeToken(RefreshToken rt) {
        refreshTokenRepository.delete(rt);
    }

    @Override
    @Transactional
    public AuthTokensResponse refreshToken(RefreshTokenRequest req) {
        RefreshToken oldRt = refreshTokenRepository.findByToken(req.getRefreshToken())
                .orElseThrow(() -> new AuthenticationException("Refresh token not found", HttpStatus.UNAUTHORIZED.value()));

        if (oldRt.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new AuthenticationException("Refresh token expired", HttpStatus.UNAUTHORIZED.value());
        }

        User u = oldRt.getUser();

        var roles = u.getUserRoles().stream()
                .map(ur -> ur.getRole().getName())
                .distinct()
                .toList();


        String newAccess = jwtHelper.generateToken(u.getEmail(), roles);

        revokeToken(oldRt);
        RefreshToken newRt = issueFor(u);

        return AuthTokensResponse.builder()
                .tokenType("Bearer")
                .accessToken(newAccess)
                .refreshToken(newRt.getToken())
                .build();
    }
}

