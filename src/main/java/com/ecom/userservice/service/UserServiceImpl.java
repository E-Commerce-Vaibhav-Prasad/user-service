package com.ecom.userservice.service;

import com.ecom.userservice.constant.UserStatus;
import com.ecom.userservice.dto.request.CreateUserRequest;
import com.ecom.userservice.dto.request.UpdateUserRequest;
import com.ecom.userservice.dto.request.UpdateUserStatusRequest;
import com.ecom.userservice.dto.response.UserResponse;
import com.ecom.userservice.dto.response.UserValidationResponse;
import com.ecom.userservice.entity.User;
import com.ecom.userservice.exception.DuplicateUserException;
import com.ecom.userservice.exception.UserNotFoundException;
import com.ecom.userservice.mapper.UserMapper;
import com.ecom.userservice.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(CreateUserRequest request) {

        // 1. Validate email
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateUserException("User already exists with Email: " + request.getEmail());
        }

        // 2. Check duplicate user

        // 3. Hash password

        // 4. Create entity
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .status(UserStatus.ACTIVE)
                .build();

        // 5. Save entity
        User savedUser = userRepository.save(user);

        // 6. Convert entity → response

        return userMapper.toUserResponse(savedUser);
    }

    public UserResponse getUser(Long userId) {
        // 1. Find user by id
        User user = findUser(userId);;
        // 2. Convert entity → response
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserResponse updateUser(Long userId, UpdateUserRequest request) {
        User user = findUser(userId);

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());

        User updatedUser = userRepository.save(user);

        return userMapper.toUserResponse(updatedUser);
    }

    @Override
    public UserResponse updateStatus(Long userId, UpdateUserStatusRequest request) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    @Transactional(readOnly = true)
    public UserValidationResponse validateUser(Long userId) {

        User user = findUser(userId);

        boolean valid =
                user.getStatus() == UserStatus.ACTIVE;

        return UserValidationResponse.builder()
                .userId(user.getId())
                .valid(valid)
                .status(user.getStatus())
                .build();
    }

    private User findUser(Long userId) {

        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found: " + userId
                        )
                );
    }
}
