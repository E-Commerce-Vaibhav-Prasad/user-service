package com.ecom.userservice.exception;

public class InvalidCredentialsException extends UserServiceException {

    public InvalidCredentialsException(String message) {
        super(message);
    }
}
