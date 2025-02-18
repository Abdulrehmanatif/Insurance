package com.example.insurance.exception;

import com.example.insurance.utils.Constants;

public class ClaimsNotFoundException extends RuntimeException {
    public ClaimsNotFoundException(String message) {
        super(message);
    }
}

