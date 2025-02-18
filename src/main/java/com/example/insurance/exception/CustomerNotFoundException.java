package com.example.insurance.exception;

import com.example.insurance.utils.Constants;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(Integer customerId) {
        super(Constants.NO_CUSTOMER_FOUND + customerId);
    }
}
