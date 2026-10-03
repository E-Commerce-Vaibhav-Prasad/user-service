package com.ecom.userservice.exception;

public class AddressNotFoundException extends UserServiceException{

    public AddressNotFoundException(String message) {
        super(message);
    }
}
