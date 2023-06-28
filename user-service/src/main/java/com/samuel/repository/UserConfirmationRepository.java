package com.samuel.repository;

import com.samuel.model.UserConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserConfirmationRepository extends JpaRepository<UserConfirmation, Long> {
}