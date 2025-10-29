package com.cybersoft.bai4.exception;

import lombok.Getter;

@Getter
public class RegistrationException extends RuntimeException {
    private final int status;

    public RegistrationException(String message, int status) {
        super(message);
        this.status = status;
    }

}
