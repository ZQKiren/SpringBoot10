package com.cybersoft.bai4.service;

import com.cybersoft.bai4.entity.RefreshToken;
import com.cybersoft.bai4.entity.User;
import com.cybersoft.bai4.request.RefreshTokenRequest;
import com.cybersoft.bai4.response.AuthTokensResponse;
import jakarta.transaction.Transactional;

public interface RefreshTokenService {
    RefreshToken issueFor(User user);
    void revokeToken(RefreshToken rt);
    AuthTokensResponse refreshToken(RefreshTokenRequest req);
}
