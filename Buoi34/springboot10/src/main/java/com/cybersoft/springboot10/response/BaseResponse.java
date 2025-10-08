package com.cybersoft.springboot10.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
    private int status;
    private String message;
    private T data;

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(200, "Success", data);
    }
    
    public static <T> BaseResponse<T> success(String message, T data) {
        return new BaseResponse<>(200, message, data);
    }

    public static <T> BaseResponse<T> error(int statusCode, String message) {
        return new BaseResponse<>(statusCode, message, null);
    }
    
    public static <T> BaseResponse<T> error(String message) {
        return new BaseResponse<>(400, message, null);
    }
}