package com.cybersoft.bai5.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignOutRequest {
    @NotBlank
    private String refreshToken;
}
