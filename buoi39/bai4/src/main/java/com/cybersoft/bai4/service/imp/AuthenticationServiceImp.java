package com.cybersoft.bai4.service.imp;

import com.cybersoft.bai4.entity.Role;
import com.cybersoft.bai4.entity.User;
import com.cybersoft.bai4.entity.UserRole;
import com.cybersoft.bai4.exception.AuthenticationException;
import com.cybersoft.bai4.exception.RegistrationException;
import com.cybersoft.bai4.repository.RoleRepository;
import com.cybersoft.bai4.repository.UserRepository;
import com.cybersoft.bai4.repository.UserRoleRepository;
import com.cybersoft.bai4.request.SignInRequest;
import com.cybersoft.bai4.request.SignUpRequest;
import com.cybersoft.bai4.response.AuthTokensResponse;
import com.cybersoft.bai4.service.AuthenticationService;
import com.cybersoft.bai4.util.JWTHelper;
import jakarta.transaction.Transactional;
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

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository RoleRepository;

    @Autowired
    private RefreshTokenServiceImp refreshTokenService;

    @Override
    public AuthTokensResponse login(SignInRequest req) {
        User u = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new AuthenticationException("Invalid email or password!", HttpStatus.UNAUTHORIZED.value()));

        if (!u.getEnabled()) throw new AuthenticationException("User is disabled!", HttpStatus.UNAUTHORIZED.value());

        if (!passwordEncoder.matches(req.getPassword(), u.getPassword()))
            throw new AuthenticationException("Invalid email or password!", HttpStatus.UNAUTHORIZED.value());

        var roles = u.getUserRoles().stream()
                .map(ur -> ur.getRole().getName())
                .distinct()
                .toList();

        String access = jwtHelper.generateToken(u.getEmail(), roles);
        var rt = refreshTokenService.issueFor(u);
        return AuthTokensResponse.builder()
                .tokenType("Bearer")
                .accessToken(access)
                .refreshToken(rt.getToken())
                .build();
    }

    @Override
    @Transactional
    public ResponseEntity<?> register(SignUpRequest req) {
        if (userRepository.existsByEmailIgnoreCase(req.getEmail()))
            throw new RegistrationException("Email already exists", HttpStatus.BAD_REQUEST.value());
        if (userRepository.existsByUsernameIgnoreCase(req.getUsername()))
            throw new RegistrationException("Username already exists", HttpStatus.BAD_REQUEST.value());

        User u = new User();
        u.setUsername(req.getUsername().trim());
        u.setEmail(req.getEmail().trim());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u.setEnabled(true);
        User userSave = userRepository.save(u);

        Role role = RoleRepository.findById(req.getRoleId())
                .orElseThrow(() -> new RegistrationException("Role not found!", HttpStatus.BAD_REQUEST.value()));

        UserRole userRole = new UserRole();
        userRole.setUser(userSave);
        userRole.setRole(role);
        userRoleRepository.save(userRole);
        return ResponseEntity.ok("Register user successfully!");
    }


}
