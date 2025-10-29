package com.cybersoft.bai3.exception;

import lombok.Getter;

@Getter
public class AuthenticationException extends RuntimeException {
    private final int status;

    public AuthenticationException(String message, int status) {
        super(message);
        this.status = status;
    }
}
