package com.cybersoft.bai2.service.imp;

import com.cybersoft.bai2.entity.User;
import com.cybersoft.bai2.repository.UserRepository;
import com.cybersoft.bai2.response.ProfileResponse;
import com.cybersoft.bai2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ProfileResponse getProfileByEmail(String email) {
        User u = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new ProfileResponse(u.getId(), u.getUsername(), u.getEmail());
    }
}
