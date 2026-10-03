package com.ecom.userservice.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class AddressResponse {

    private Long id;

    private Long userId;

    private String recipientName;

    private String phone;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String country;

    private String pincode;

    private String addressType;

    private Boolean defaultAddress;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
