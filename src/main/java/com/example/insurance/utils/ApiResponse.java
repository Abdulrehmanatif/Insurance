package com.example.insurance.utils;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private Integer status;
    private String message;
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiResponse(Integer status, String message, T data) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}
