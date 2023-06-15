package com.samuel.model;

import com.samuel.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "email",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "phone",
                        columnNames = "phone"
                )
        }
)
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq"
    )
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_seq",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "bio")
    private String bio;

    @Column(name = "username")
    private String username;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "website")
    private String website;

    @Column(name = "location")
    private String location;

    @Column(name = "profile_image")
    private String profile_image;

    @Column(name = "banner_image")
    private String banner_image;

    @Column(name = "country")
    private String country;

    @Column(name = "country_code")
    private String countryCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role = Role.USER;

    @Column(name = "language")
    private String language;

    @Column(name = "verified")
    private boolean verified =  false;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "updated_at")
    private LocalDateTime UpdatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserActivity> userActivities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Follower> followers;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserStatistics userStatistics;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserConfirmation userConfirmation;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserMetadata userMetadata;


}
