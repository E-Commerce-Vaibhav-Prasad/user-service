package com.ecom.userservice.repository;

import com.ecom.userservice.constant.UserStatus;
import com.ecom.userservice.entity.Address;
import com.ecom.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUserId(Long userId);

    Optional<Address> findByIdAndUserId(
            Long addressId,
            Long userId
    );

    Optional<Address> findByUserIdAndDefaultAddressTrue(
            Long userId
    );

    boolean existsByIdAndUserId(
            Long addressId,
            Long userId
    );
}
