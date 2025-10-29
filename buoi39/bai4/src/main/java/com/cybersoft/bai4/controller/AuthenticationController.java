package com.cybersoft.bai4.controller;

import com.cybersoft.bai4.request.RefreshTokenRequest;
import com.cybersoft.bai4.request.SignInRequest;
import com.cybersoft.bai4.request.SignUpRequest;
import com.cybersoft.bai4.service.AuthenticationService;
import com.cybersoft.bai4.service.RefreshTokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
