package com.cybersoft.bai5.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserCreateRequest {
    @NotBlank
    @Size(min=3,max=50)
    private String username;
    @NotBlank
    @Email
    @Size(max=100)
    private String email;
    @NotBlank
    @Size(min=6,max=100)
    private String password;
    private List<Long> roleIds; // optional
}
