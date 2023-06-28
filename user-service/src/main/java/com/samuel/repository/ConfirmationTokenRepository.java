package com.samuel.repository;

import com.samuel.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {


    Optional<ConfirmationToken> findByToken(String token);

    @Modifying
    @Query(
            value = "update confirmation_token SET confirmed_at = ?2 WHERE token = ?1",
            nativeQuery = true
    )
    void  updateConfirmedAt(String token, String confirmedAt);
}
