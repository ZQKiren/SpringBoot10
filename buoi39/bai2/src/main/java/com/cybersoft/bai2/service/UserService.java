package com.cybersoft.bai2.service;

import com.cybersoft.bai2.response.ProfileResponse;

public interface UserService {
    ProfileResponse getProfileByEmail(String email);
}
