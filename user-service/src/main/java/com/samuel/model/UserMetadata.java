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
public class UserMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "gender")
    private long gender;

    @Column(name = "education")
    private long education;

    @Column(name = "interests")
    private long interests;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "occupation")
    private String occupation;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
