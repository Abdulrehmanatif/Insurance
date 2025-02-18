package com.example.insurance.dto;

import lombok.Data;

@Data
public class ErrorResponse {

    private String message;
    private Integer status;

    public ErrorResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
