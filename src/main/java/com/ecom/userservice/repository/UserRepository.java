package com.ecom.userservice.repository;

import com.ecom.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long aLong);

    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
