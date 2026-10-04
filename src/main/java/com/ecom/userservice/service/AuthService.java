package com.ecom.userservice.service;

import com.ecom.userservice.constant.UserStatus;
import com.ecom.userservice.dto.request.LoginRequest;
import com.ecom.userservice.dto.response.AuthResponse;
import com.ecom.userservice.entity.User;
import com.ecom.userservice.exception.InvalidCredentialsException;
import com.ecom.userservice.repository.UserRepository;
import com.ecom.userservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException("Invalid email or password")
                );

        if (user.getPasswordHash() == null
                || !passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new InvalidCredentialsException("Invalid email or password");
        }

        if (user.getStatus() != UserStatus.ACTIVE) {
            throw new InvalidCredentialsException("User is not active");
        }

        return AuthResponse.builder()
                .token(jwtService.generateToken(user))
                .tokenType("Bearer")
                .userId(user.getId())
                .build();
    }
}
