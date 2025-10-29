package com.cybersoft.bai5.service;

import com.cybersoft.bai5.entity.RefreshToken;
import com.cybersoft.bai5.entity.User;
import com.cybersoft.bai5.request.RefreshTokenRequest;
import com.cybersoft.bai5.response.AuthTokensResponse;

public interface RefreshTokenService {
    RefreshToken issueFor(User user);
    void revokeToken(RefreshToken rt);
    AuthTokensResponse refreshToken(RefreshTokenRequest req);
}
