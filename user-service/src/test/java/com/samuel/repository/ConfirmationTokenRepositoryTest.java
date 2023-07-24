package com.samuel.repository;

import com.samuel.model.ConfirmationToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ConfirmationTokenRepositoryTest {

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @BeforeEach
    void setUp() {
        confirmationTokenRepository.deleteAll();
    }

    @Test
    void findByToken() {
        String token = "token";
        ConfirmationToken confirmationToken =
                new ConfirmationToken(
                        100L, token, LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(15),
                        LocalDateTime.now().plusMinutes(15),
                        null
                );
        confirmationTokenRepository.save(confirmationToken);

      String result = confirmationTokenRepository.findByToken(token).get().getToken();

      assertNotNull(token);
      assertEquals(token, result);
    }

    @Test
    void updateConfirmedAt() {
    }
}