package com.example.tweetservcie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(
        name = "comments",
        indexes = {
                @Index(name = "comment_user_id_index", columnList = "user_id"),
                @Index(name = "comment_tweet_id_index", columnList = "tweet_id"),
        }
)
public class Comment {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_generator"
    )
    @SequenceGenerator(
            name = "comment_seq",
            sequenceName = "comment_seq"
    )
    private Long id;

    @Column(name = "comment_msg")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;

    @Column(name = "user_id")
    private Long userId;
}
