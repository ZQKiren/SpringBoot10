package com.cybersoft.bai1.service.imp;

import com.cybersoft.bai1.entity.User;
import com.cybersoft.bai1.repository.UserRepository;
import com.cybersoft.bai1.request.SignInRequest;
import com.cybersoft.bai1.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String checkLogin(SignInRequest req) {
        Optional<User> optionalUser = userRepository.findByUsername(req.getUsername());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(req.getPassword())) {
                return "Hello " + user.getUsername();
            }
        }
        return "Login failed";
    }
}
