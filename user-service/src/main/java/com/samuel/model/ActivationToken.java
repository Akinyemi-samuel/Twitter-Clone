package com.samuel.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "activation_token")
public class ActivationToken {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "activation_token_generator"
    )
    @SequenceGenerator(
            sequenceName = "activation_token_sequence",
            name = "activation_token_generator",
            allocationSize = 1,
            initialValue = 100

    )
    private Long id;

    private String token;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    private LocalDateTime ConfirmedAt;

    @OneToOne
    @JoinColumn(name = "User_id")
    private User user;
}
