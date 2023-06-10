package com.samuel.repository;

import com.samuel.model.UserMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMetadataRepository extends JpaRepository<UserMetadata, Long> {
}