package com.samuel.repository;

import com.samuel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Modifying
    @Query(
            value = "UPDATE user SET password = :password WHERE user_id = :userId",
            nativeQuery = true
    )
    void updatePasswordById(Long userId, String password);
}