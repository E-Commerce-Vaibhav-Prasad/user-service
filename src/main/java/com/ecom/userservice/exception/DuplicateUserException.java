package com.ecom.userservice.exception;

public class DuplicateUserException extends UserServiceException{

    public DuplicateUserException(String message) {
        super(message);
    }
}
