package com.ecom.userservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAddressRequest {

    @NotBlank
    @Size(max = 150)
    private String recipientName;

    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone must contain exactly 10 digits"
    )
    private String phone;

    @NotBlank
    private String addressLine1;

    private String addressLine2;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String country;

    @NotBlank
    private String pincode;

    @NotBlank
    private String addressType;

}