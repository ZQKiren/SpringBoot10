package com.cybersoft.bai3.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {

    @NotBlank @Email
    private String email;

    @NotBlank
    private String password;
}
