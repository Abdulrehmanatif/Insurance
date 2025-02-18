package com.example.insurance.exception;

import com.example.insurance.utils.Constants;

public class ClaimsNotFoundException extends Exception {
    public ClaimsNotFoundException(Integer customerId) {
        super(Constants.NO_CLAIMS_FOUND + customerId);
    }
}

