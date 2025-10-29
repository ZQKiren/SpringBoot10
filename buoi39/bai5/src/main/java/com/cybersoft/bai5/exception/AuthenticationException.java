package com.cybersoft.bai5.exception;

import lombok.Getter;

@Getter
public class AuthenticationException extends RuntimeException {
    private final int status;

    public AuthenticationException(String message, int status) {
        super(message);
        this.status = status;
    }
}
