package com.ecom.userservice.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResponse {

    private String token;

    private String tokenType;

    private Long userId;
}
