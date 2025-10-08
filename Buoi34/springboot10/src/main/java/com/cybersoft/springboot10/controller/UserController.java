package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.entity.User;
import com.cybersoft.springboot10.response.BaseResponse;
import com.cybersoft.springboot10.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<BaseResponse<User>> addUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(BaseResponse.error(400, "Dữ liệu không hợp lệ"));
        }
        
        User savedUser = userService.addUser(user);
        return ResponseEntity.ok(BaseResponse.success("Thêm user thành công", savedUser));
    }
}
