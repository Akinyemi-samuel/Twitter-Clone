package com.samuel.repository.projection;

import java.time.LocalDateTime;

/**
 * Projection for {@link com.samuel.model.User}
 */
public interface UserProfileProjection {
     Long getUser_id();

    String getFullname();

    String getBio();

    String getUsername();

    String getPhone();

    String getEmail();

    String getWebsite();

    String getLocation();

    String getProfile_image();

    String getBanner_image();

    String getCountry();

    boolean isVerified();

    LocalDateTime getRegistration_date();

    LocalDateTime getUpdated_at();
}