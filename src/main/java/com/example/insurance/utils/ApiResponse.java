package com.example.insurance.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ApiResponse {

    private Integer status;
    private String message;
    private Object data;

    public ApiResponse() {
    }

    public ApiResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiResponse(Integer status, String message, Object data) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}
