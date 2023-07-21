package com.samuel.repository;

import com.samuel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("update User u set u.password = ?1 where u.userId = ?2")
    int updatePasswordByUserId(String password, Long userId);

    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(
            value = "update users set password = :password WHERE user_id = :userId",
            nativeQuery = true
    )
    int updatePasswordById(Long userId, String password);
}