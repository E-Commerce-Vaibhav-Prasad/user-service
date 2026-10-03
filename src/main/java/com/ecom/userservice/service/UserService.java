package com.ecom.userservice.service;

import com.ecom.userservice.dto.request.CreateUserRequest;
import com.ecom.userservice.dto.response.UserResponse;
import com.ecom.userservice.entity.User;
import com.ecom.userservice.exception.UserNotFoundException;
import com.ecom.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse createUser(CreateUserRequest request) {

        // 1. Validate email

        // 2. Check duplicate user

        // 3. Hash password

        // 4. Create entity

        // 5. Save entity

        // 6. Convert entity → response

        return null;
    }

    public UserResponse getUser(Long userId) {
        // 1. Find user by id
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        // 2. Convert entity → response

        return null;
    }
}
