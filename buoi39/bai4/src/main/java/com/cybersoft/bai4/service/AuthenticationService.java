package com.cybersoft.bai4.service;

import com.cybersoft.bai4.request.SignInRequest;
import com.cybersoft.bai4.request.SignUpRequest;
import com.cybersoft.bai4.response.AuthTokensResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    AuthTokensResponse login(SignInRequest req);
    ResponseEntity<?> register(SignUpRequest req);
}
