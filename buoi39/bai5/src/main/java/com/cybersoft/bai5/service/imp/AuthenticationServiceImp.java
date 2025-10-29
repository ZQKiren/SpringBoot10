package com.cybersoft.bai5.service.imp;

import com.cybersoft.bai5.entity.Role;
import com.cybersoft.bai5.entity.User;
import com.cybersoft.bai5.entity.UserRole;
import com.cybersoft.bai5.exception.AuthenticationException;
import com.cybersoft.bai5.exception.RegistrationException;
import com.cybersoft.bai5.mapper.UserMapper;
import com.cybersoft.bai5.repository.RefreshTokenRepository;
import com.cybersoft.bai5.repository.RoleRepository;
import com.cybersoft.bai5.repository.UserRepository;
import com.cybersoft.bai5.repository.UserRoleRepository;
import com.cybersoft.bai5.request.ChangePasswordRequest;
import com.cybersoft.bai5.request.SignInRequest;
import com.cybersoft.bai5.request.SignOutRequest;
import com.cybersoft.bai5.request.SignUpRequest;
import com.cybersoft.bai5.response.AuthTokensResponse;
import com.cybersoft.bai5.response.UserResponse;
import com.cybersoft.bai5.service.AuthenticationService;
import com.cybersoft.bai5.util.JWTHelper;
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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

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

    @Override
    public UserResponse me(String email) {
        User u = userRepository.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException("User not found", HttpStatus.UNAUTHORIZED.value()));
        return userMapper.toUserResponse(u);
    }

    @Transactional
    @Override
    public void logout(String email, SignOutRequest req) {
        User u = userRepository.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException("User not found", HttpStatus.UNAUTHORIZED.value()));

        refreshTokenRepository.findByToken(req.getRefreshToken())
                .filter(rt -> rt.getUser().getId().equals(u.getId()))
                .ifPresent(refreshTokenRepository::delete);
    }

    @Transactional
    @Override
    public void changePassword(String email, ChangePasswordRequest req) {
        User u = userRepository.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException("User not found", HttpStatus.UNAUTHORIZED.value()));

        if (!passwordEncoder.matches(req.getOldPassword(), u.getPassword())) {
            throw new AuthenticationException("Old password invalid", HttpStatus.UNAUTHORIZED.value());
        }

        u.setPassword(passwordEncoder.encode(req.getNewPassword()));
        userRepository.save(u);

        refreshTokenRepository.deleteByUser(u);
    }
}
