package com.samuel.model;

import jakarta.persistence.*;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user_confirmation")
public class UserConfirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "email_confirmed")
    private boolean emailConfirmed = false;

    @Column(name = "phone_confirmed")
    private boolean phoneConfirmed = false;
}
