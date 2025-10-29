package com.cybersoft.bai5.controller;

import com.cybersoft.bai5.request.AssignRolesRequest;
import com.cybersoft.bai5.request.UserCreateRequest;
import com.cybersoft.bai5.request.UserUpdateRequest;
import com.cybersoft.bai5.response.UserResponse;
import com.cybersoft.bai5.service.AdminUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController {

    private final AdminUserService adminUserService;

    @GetMapping
    public List<UserResponse> list() {
        return adminUserService.list();
    }

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable Long id) {
        return adminUserService.get(id);
    }

    @PostMapping
    public UserResponse create(@Valid @RequestBody UserCreateRequest req) {
        return adminUserService.create(req);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @Valid @RequestBody UserUpdateRequest req) {
        return adminUserService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        adminUserService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/roles")
    public UserResponse assignRoles(@PathVariable Long id, @Valid @RequestBody AssignRolesRequest req) {
        return adminUserService.assignRoles(id, req);
    }
}
