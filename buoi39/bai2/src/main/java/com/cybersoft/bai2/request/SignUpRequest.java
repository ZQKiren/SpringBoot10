package com.cybersoft.bai2.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    @NotBlank
    @Size(min=3, max=50)
    private String username;
    @NotBlank @Email
    @Size(max=100)
    private String email;
    @NotBlank @Size(min=4, max=100)
    private String password;
}
