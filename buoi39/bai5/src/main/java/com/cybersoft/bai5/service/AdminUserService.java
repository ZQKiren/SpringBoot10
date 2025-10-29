package com.cybersoft.bai5.service;

import com.cybersoft.bai5.request.AssignRolesRequest;
import com.cybersoft.bai5.request.UserCreateRequest;
import com.cybersoft.bai5.request.UserUpdateRequest;
import com.cybersoft.bai5.response.UserResponse;

import java.util.List;

public interface AdminUserService {
    List<UserResponse> list();
    UserResponse get(Long id);
    UserResponse create(UserCreateRequest req);
    UserResponse update(Long id, UserUpdateRequest req);
    void delete(Long id);
    UserResponse assignRoles(Long id, AssignRolesRequest req);
}
