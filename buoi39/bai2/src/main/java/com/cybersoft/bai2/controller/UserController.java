package com.cybersoft.bai2.controller;

import com.cybersoft.bai2.response.ProfileResponse;
import com.cybersoft.bai2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("Hello User");
    }

    @GetMapping("/profile")
    public ResponseEntity<?> profile(Authentication authentication) {
        String email = authentication.getName();
        ProfileResponse res = userService.getProfileByEmail(email);
        return ResponseEntity.ok(res);
    }
}
