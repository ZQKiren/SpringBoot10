package com.cybersoft.bai5.service.imp;

import com.cybersoft.bai5.entity.Role;
import com.cybersoft.bai5.entity.User;
import com.cybersoft.bai5.entity.UserRole;
import com.cybersoft.bai5.mapper.UserMapper;
import com.cybersoft.bai5.repository.RoleRepository;
import com.cybersoft.bai5.repository.UserRepository;
import com.cybersoft.bai5.repository.UserRoleRepository;
import com.cybersoft.bai5.request.AssignRolesRequest;
import com.cybersoft.bai5.request.UserCreateRequest;
import com.cybersoft.bai5.request.UserUpdateRequest;
import com.cybersoft.bai5.response.UserResponse;
import com.cybersoft.bai5.service.AdminUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminUserServiceImp implements AdminUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;

    @Override
    public List<UserResponse> list() {
        return userRepository.findAll().stream()
                .map(mapper::toUserResponse)
                .toList();
    }

    @Override
    public UserResponse get(Long id) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return mapper.toUserResponse(u);
    }

    @Override
    @Transactional
    public UserResponse create(UserCreateRequest req) {
        if (userRepository.existsByEmailIgnoreCase(req.getEmail()))
            throw new IllegalArgumentException("Email already exists");
        if (userRepository.existsByUsernameIgnoreCase(req.getUsername()))
            throw new IllegalArgumentException("Username already exists");

        User u = new User();
        u.setUsername(req.getUsername().trim());
        u.setEmail(req.getEmail().trim());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u.setEnabled(true);
        u = userRepository.save(u);

        if (req.getRoleIds() != null && !req.getRoleIds().isEmpty()) {
            for (Long rid : req.getRoleIds()) {
                Role r = roleRepository.findById(rid)
                        .orElseThrow(() -> new IllegalArgumentException("Role not found: " + rid));
                userRoleRepository.save(UserRole.builder().user(u).role(r).build());
            }
        }

        return mapper.toUserResponse(u);
    }

    @Override
    @Transactional
    public UserResponse update(Long id, UserUpdateRequest req) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (req.getUsername() != null && !req.getUsername().isBlank())
            u.setUsername(req.getUsername().trim());
        if (req.getEmail() != null && !req.getEmail().isBlank())
            u.setEmail(req.getEmail().trim());
        if (req.getEnabled() != null)
            u.setEnabled(req.getEnabled());

        u = userRepository.save(u);
        return mapper.toUserResponse(u);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserResponse assignRoles(Long id, AssignRolesRequest req) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        userRoleRepository.deleteByUser(u);

        for (Long rid : req.getRoleIds()) {
            Role r = roleRepository.findById(rid)
                    .orElseThrow(() -> new IllegalArgumentException("Role not found: " + rid));
            userRoleRepository.save(UserRole.builder().user(u).role(r).build());
        }

        return mapper.toUserResponse(u);
    }
}
