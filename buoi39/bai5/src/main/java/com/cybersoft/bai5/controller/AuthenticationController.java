package com.cybersoft.bai5.controller;

import com.cybersoft.bai5.request.RefreshTokenRequest;
import com.cybersoft.bai5.request.SignInRequest;
import com.cybersoft.bai5.request.SignUpRequest;
import com.cybersoft.bai5.service.AuthenticationService;
import com.cybersoft.bai5.service.RefreshTokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignUpRequest req) {
        return ResponseEntity.ok(authenticationService.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignInRequest req) {
        return ResponseEntity.ok(authenticationService.login(req));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody @Valid RefreshTokenRequest req) {
        return ResponseEntity.ok(refreshTokenService.refreshToken(req));
    }
}
