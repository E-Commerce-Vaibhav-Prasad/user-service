package com.ecom.userservice.service;

import com.ecom.userservice.dto.request.CreateAddressRequest;
import com.ecom.userservice.dto.request.UpdateAddressRequest;
import com.ecom.userservice.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {

    AddressResponse createAddress(
            Long userId,
            CreateAddressRequest request
    );

    AddressResponse getAddress(
            Long userId,
            Long addressId
    );

    List<AddressResponse> getAddresses(
            Long userId
    );

    AddressResponse updateAddress(
            Long userId,
            Long addressId,
            UpdateAddressRequest request
    );

    void deleteAddress(
            Long userId,
            Long addressId
    );

    AddressResponse setDefaultAddress(
            Long userId,
            Long addressId
    );
}
