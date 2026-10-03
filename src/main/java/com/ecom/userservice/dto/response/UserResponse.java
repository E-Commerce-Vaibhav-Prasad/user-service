package com.ecom.userservice.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
