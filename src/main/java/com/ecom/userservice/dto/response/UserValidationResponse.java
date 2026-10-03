package com.ecom.userservice.dto.response;

import com.ecom.userservice.constant.UserStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserValidationResponse {

    private Long userId;

    private boolean valid;

    private UserStatus status;
}
