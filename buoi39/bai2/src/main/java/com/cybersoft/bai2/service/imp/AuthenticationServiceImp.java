package com.cybersoft.bai2.service.imp;

import com.cybersoft.bai2.entity.User;
import com.cybersoft.bai2.exception.AuthenticationException;
import com.cybersoft.bai2.exception.RegistrationException;
import com.cybersoft.bai2.repository.UserRepository;
import com.cybersoft.bai2.request.SignInRequest;
import com.cybersoft.bai2.request.SignUpRequest;
import com.cybersoft.bai2.response.JwtResponse;
import com.cybersoft.bai2.service.AuthenticationService;
import com.cybersoft.bai2.util.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTHelper jwtHelper;

    @Override
    public JwtResponse login(SignInRequest req) {
        User u = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new AuthenticationException("Invalid email or password!", HttpStatus.UNAUTHORIZED.value()));

        if (!u.getEnabled()) throw new AuthenticationException("User is disabled!", HttpStatus.UNAUTHORIZED.value());

        if (!passwordEncoder.matches(req.getPassword(), u.getPassword()))
            throw new AuthenticationException("Invalid email or password!", HttpStatus.UNAUTHORIZED.value());

        String token = jwtHelper.generateToken(u.getEmail());
        return new JwtResponse(token, "Bearer");
    }

    @Override
    public ResponseEntity<?> register(SignUpRequest req) {
        if (userRepository.existsByEmailIgnoreCase(req.getEmail())) {
            throw new RegistrationException("Email already exists", HttpStatus.BAD_REQUEST.value());
        }
        if (userRepository.existsByUsernameIgnoreCase(req.getUsername())) {
            throw new RegistrationException("Username already exists", HttpStatus.BAD_REQUEST.value());
        }

        User u = new User();
        u.setUsername(req.getUsername().trim());
        u.setEmail(req.getEmail().trim());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u.setEnabled(true);

        User saved = userRepository.save(u);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
