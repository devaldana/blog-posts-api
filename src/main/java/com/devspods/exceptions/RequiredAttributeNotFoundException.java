package com.devspods.exceptions;

public class RequiredAttributeNotFoundException extends RuntimeException {

    public RequiredAttributeNotFoundException(String message) {
        super(message);
    }
}
