package com.ecom.userservice.mapper;

import com.ecom.userservice.dto.response.AddressResponse;
import com.ecom.userservice.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressResponse toResponse(Address address) {

        return AddressResponse.builder()
                .id(address.getId())
                .userId(address.getUser().getId())
                .recipientName(address.getRecipientName())
                .phone(address.getPhone())
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .pincode(address.getPincode())
                .addressType(String.valueOf(address.getAddressType()))
                .defaultAddress(address.getDefaultAddress())
                .createdAt(address.getCreatedAt())
                .updatedAt(address.getUpdatedAt())
                .build();
    }
}
