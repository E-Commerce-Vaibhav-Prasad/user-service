package com.ecom.userservice.controller;

import com.ecom.userservice.dto.request.CreateAddressRequest;
import com.ecom.userservice.dto.response.AddressResponse;
import com.ecom.userservice.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/{userId}/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(
            @PathVariable Long userId,
            @Valid @RequestBody CreateAddressRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addressService.createAddress(userId, request));
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressResponse> getAddress(
            @PathVariable Long userId,
            @PathVariable Long addressId) {

        return ResponseEntity.ok(
                addressService.getAddress(userId, addressId)
        );
    }
}
