package com.samuel.repository;

import com.samuel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query(
            nativeQuery = true,
            value = "SELECT * FROM users where user_id = :userId"
    )
    <T> Optional<T> findUserById(Long userId, Class<T> type);

    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(
            value = "update users set password = :password WHERE user_id = :userId",
            nativeQuery = true
    )
    void updatePasswordById(Long userId, String password);


}