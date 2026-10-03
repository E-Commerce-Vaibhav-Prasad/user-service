package com.ecom.userservice.dto.request;

import com.ecom.userservice.constant.UserStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserStatusRequest {

    @NotNull(message = "Status is required")
    private UserStatus status;
}