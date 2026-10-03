package com.ecom.userservice.dto.response;

import com.ecom.userservice.constant.UserStatus;

public class UserResponse {
    Long id;
    String firstName;
    String lastName;
    String email;
    String phone;
    UserStatus status;
}
