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
@Table(name = "user_metadata")
public class UserMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "gender")
    private String gender;

    @Column(name = "education")
    private String education;

    @Column(name = "interests")
    private String interests;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "occupation")
    private String occupation;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
