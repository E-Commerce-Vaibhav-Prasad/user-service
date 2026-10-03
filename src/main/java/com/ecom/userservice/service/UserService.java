package com.ecom.userservice.service;

import com.ecom.userservice.dto.request.CreateUserRequest;
import com.ecom.userservice.dto.request.UpdateUserRequest;
import com.ecom.userservice.dto.request.UpdateUserStatusRequest;
import com.ecom.userservice.dto.response.UserResponse;
import com.ecom.userservice.dto.response.UserValidationResponse;

public interface UserService {

    UserResponse createUser(CreateUserRequest request);

    UserResponse getUser(Long userId);

    UserResponse getUserByEmail(String email);

    UserResponse updateUser(
            Long userId,
            UpdateUserRequest request);

    UserResponse updateStatus(
            Long userId,
            UpdateUserStatusRequest request);

    void deleteUser(Long userId);
    public UserValidationResponse validateUser(Long userId);
}
