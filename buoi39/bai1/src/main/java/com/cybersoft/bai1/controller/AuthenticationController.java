package com.cybersoft.bai1.controller;

import com.cybersoft.bai1.request.SignInRequest;
import com.cybersoft.bai1.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/hello")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest req) {
        return ResponseEntity.ok(authenticationService.checkLogin(req));
    }
}
