package com.ecom.userservice.service;

import com.ecom.userservice.constant.AddressType;
import com.ecom.userservice.dto.request.CreateAddressRequest;
import com.ecom.userservice.dto.request.UpdateAddressRequest;
import com.ecom.userservice.dto.response.AddressResponse;
import com.ecom.userservice.entity.Address;
import com.ecom.userservice.exception.AddressNotFoundException;
import com.ecom.userservice.exception.UserNotFoundException;
import com.ecom.userservice.mapper.AddressMapper;
import com.ecom.userservice.repository.AddressRepository;
import com.ecom.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressServiceImpl implements AddressService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponse createAddress(
            Long userId,
            CreateAddressRequest request) {

        validateUser(userId);

        if (Boolean.TRUE.equals(request.getDefaultAddress())) {
            clearDefaultAddress(userId);
        }

        Address address = Address.builder()
                .user(userRepository.getById(userId))
                .recipientName(request.getRecipientName())
                .phone(request.getPhone())
                .addressLine1(request.getAddressLine1())
                .addressLine2(request.getAddressLine2())
                .city(request.getCity())
                .state(request.getState())
                .country(request.getCountry())
                .pincode(request.getPincode())
                .addressType(AddressType.valueOf(request.getAddressType()))
                .defaultAddress(
                        Boolean.TRUE.equals(
                                request.getDefaultAddress()
                        )
                )
                .build();

        Address saved = addressRepository.save(address);

        return addressMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public AddressResponse getAddress(
            Long userId,
            Long addressId) {

        Address address = findAddress(
                userId,
                addressId
        );

        return addressMapper.toResponse(address);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressResponse> getAddresses(
            Long userId) {

        validateUser(userId);

        return addressRepository
                .findByUserId(userId)
                .stream()
                .map(addressMapper::toResponse)
                .toList();
    }

    @Override
    public AddressResponse updateAddress(
            Long userId,
            Long addressId,
            UpdateAddressRequest request) {

        Address address =
                findAddress(userId, addressId);

//        if (Boolean.TRUE.equals(request.getDefaultAddress())) {
//            clearDefaultAddress(userId);
//        }

        address.setRecipientName(
                request.getRecipientName()
        );
        address.setPhone(request.getPhone());
        address.setAddressLine1(
                request.getAddressLine1()
        );
        address.setAddressLine2(
                request.getAddressLine2()
        );
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setCountry(request.getCountry());
        address.setPincode(request.getPincode());
        address.setAddressType(
                AddressType.valueOf(request.getAddressType())
        );
//        address.setDefaultAddress(
//                Boolean.TRUE.equals(
//                        request.getDefaultAddress()
//                )
//        );

        return addressMapper.toResponse(
                addressRepository.save(address)
        );
    }

    @Override
    public void deleteAddress(
            Long userId,
            Long addressId) {

        Address address =
                findAddress(userId, addressId);

        addressRepository.delete(address);
    }

    @Override
    public AddressResponse setDefaultAddress(
            Long userId,
            Long addressId) {

        Address address =
                findAddress(userId, addressId);

        clearDefaultAddress(userId);

        address.setDefaultAddress(true);

        return addressMapper.toResponse(
                addressRepository.save(address)
        );
    }

    private Address findAddress(
            Long userId,
            Long addressId) {

        return addressRepository
                .findByIdAndUserId(addressId, userId)
                .orElseThrow(() ->
                        new AddressNotFoundException(
                                "Address not found: "
                                        + addressId
                        )
                );
    }

    private void validateUser(Long userId) {

        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(
                    "User not found: " + userId
            );
        }
    }

    private void clearDefaultAddress(Long userId) {

        addressRepository
                .findByUserIdAndDefaultAddressTrue(userId)
                .ifPresent(address -> {
                    address.setDefaultAddress(false);
                    addressRepository.save(address);
                });
    }
}
