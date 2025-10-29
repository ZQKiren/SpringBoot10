package com.cybersoft.bai5.service;

import com.cybersoft.bai5.request.ChangePasswordRequest;
import com.cybersoft.bai5.request.SignInRequest;
import com.cybersoft.bai5.request.SignOutRequest;
import com.cybersoft.bai5.request.SignUpRequest;
import com.cybersoft.bai5.response.AuthTokensResponse;
import com.cybersoft.bai5.response.UserResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    AuthTokensResponse login(SignInRequest req);
    ResponseEntity<?> register(SignUpRequest req);
    UserResponse me(String email);
    void logout(String email, SignOutRequest req);
    void changePassword(String email, ChangePasswordRequest req);
}
