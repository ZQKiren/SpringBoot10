package com.cybersoft.bai2.service;

import com.cybersoft.bai2.request.SignInRequest;
import com.cybersoft.bai2.request.SignUpRequest;
import com.cybersoft.bai2.response.JwtResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    JwtResponse login(SignInRequest req);

    ResponseEntity<?> register(SignUpRequest req);
}
