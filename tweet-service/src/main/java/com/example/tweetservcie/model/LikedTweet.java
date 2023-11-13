package com.example.tweetservcie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "liked_tweet",
        indexes = {
                @Index(name = "liked_tweets_user_id_index", columnList = "user_id"),
                @Index(name = "liked_tweets_tweet_id_index", columnList = "tweet_id"),
        }
)
public class LikedTweet {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "liked_tweet_generator"
    )
    @SequenceGenerator(
            sequenceName = "liked_tweet_seq",
            name = "liked_tweet_seq"
    )
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "tweet_id")
    private Long tweetId;

    @Column(name = "liked_date")
    private LocalDateTime likedDate =LocalDateTime.now();
}
