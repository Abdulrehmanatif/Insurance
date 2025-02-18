package com.example.insurance.exception;

import com.example.insurance.utils.Constants;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
