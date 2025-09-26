package com.cybersoft.springboot10.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private String error;
    private int status;
}
