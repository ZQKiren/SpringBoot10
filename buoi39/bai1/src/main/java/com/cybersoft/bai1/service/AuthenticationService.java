package com.cybersoft.bai1.service;

import com.cybersoft.bai1.request.SignInRequest;

public interface AuthenticationService {
    String checkLogin(SignInRequest req);
}
