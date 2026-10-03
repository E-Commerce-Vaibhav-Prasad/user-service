package com.ecom.userservice.controller;

import com.ecom.userservice.dto.request.CreateUserRequest;
import com.ecom.userservice.dto.request.UpdateUserRequest;
import com.ecom.userservice.dto.response.UserResponse;
import com.ecom.userservice.dto.response.UserValidationResponse;
import com.ecom.userservice.service.UserService;
import com.ecom.userservice.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody CreateUserRequest request) {

        UserResponse response =
                userService.createUser(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                userService.getUser(userId)
        );
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Long userId,
            @Valid @RequestBody UpdateUserRequest request) {

        return ResponseEntity.ok(
                userService.updateUser(userId, request)
        );
    }

    @GetMapping("/{userId}/validation")
    public ResponseEntity<UserValidationResponse> validateUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                userService.validateUser(userId)
        );
    }

}
