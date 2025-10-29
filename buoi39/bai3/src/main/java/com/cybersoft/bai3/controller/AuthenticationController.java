package com.cybersoft.bai3.controller;

import com.cybersoft.bai3.request.SignInRequest;
import com.cybersoft.bai3.request.SignUpRequest;
import com.cybersoft.bai3.service.AuthenticationService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignUpRequest req) {
        return ResponseEntity.ok(authenticationService.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignInRequest req) {
        return ResponseEntity.ok(authenticationService.login(req));
    }
}
