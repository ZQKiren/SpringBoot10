package com.cybersoft.bai2.controller;

import com.cybersoft.bai2.request.SignInRequest;
import com.cybersoft.bai2.request.SignUpRequest;
import com.cybersoft.bai2.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
