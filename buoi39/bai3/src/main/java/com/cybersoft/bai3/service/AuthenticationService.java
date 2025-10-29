package com.cybersoft.bai3.service;

import com.cybersoft.bai3.request.SignInRequest;
import com.cybersoft.bai3.request.SignUpRequest;
import com.cybersoft.bai3.response.JwtResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    JwtResponse login(SignInRequest req);
    ResponseEntity<?> register(SignUpRequest req);
}
