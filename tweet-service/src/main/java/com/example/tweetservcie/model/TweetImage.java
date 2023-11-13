package com.example.tweetservcie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tweet_Image")
public class TweetImage {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "retweet_generator"
    )
    @SequenceGenerator(
            sequenceName = "retweet_seq",
            name = "retweet_seq"
    )
    private Long id;

    @NonNull
    @Column(name = "src")
    private String src;
}
