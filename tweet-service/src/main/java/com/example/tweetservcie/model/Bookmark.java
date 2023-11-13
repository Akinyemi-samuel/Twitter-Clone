package com.example.tweetservcie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(
        name = "bookmark",
        indexes = {
                @Index(name = "bookmark_user_id_index", columnList = "user_id"),
                @Index(name = "bookmark_tweet_id_index", columnList = "tweet_id"),
        }
)
public class Bookmark {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bookmark_generator"
    )
    @SequenceGenerator(
            name = "bookmark_seq",
            sequenceName = "bookmark_seq"
    )
    private Long id;

    @Column(name = "tweet_id")
    private Long tweet;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "bookmark_date")
    private LocalDateTime bookmarkDate =LocalDateTime.now();
}
