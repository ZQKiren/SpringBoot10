package com.cybersoft.bai5.mapper;

import com.cybersoft.bai5.entity.User;
import com.cybersoft.bai5.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public UserResponse toUserResponse(User u) {
        List<String> roles = (u.getUserRoles() == null) ? List.of()
                : u.getUserRoles().stream()
                .map(ur -> ur.getRole().getName())
                .distinct()
                .toList();

        return UserResponse.builder()
                .id(u.getId())
                .email(u.getEmail())
                .username(u.getUsername())
                .enabled(Boolean.TRUE.equals(u.getEnabled()))
                .roles(roles)
                .build();
    }
}
