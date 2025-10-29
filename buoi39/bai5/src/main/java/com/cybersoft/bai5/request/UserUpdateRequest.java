package com.cybersoft.bai5.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {
    @Size(min = 3, max = 50)
    private String username;

    @Email
    @Size(max = 100)
    private String email;

    private Boolean enabled;
}
