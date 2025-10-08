package com.cybersoft.springboot10.service.imp;

import com.cybersoft.springboot10.entity.User;
import com.cybersoft.springboot10.repository.UserRepository;
import com.cybersoft.springboot10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
