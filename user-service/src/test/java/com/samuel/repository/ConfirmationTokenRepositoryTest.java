package com.samuel.repository;

import com.samuel.model.ConfirmationToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
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
    @DisplayName("Test if the method *findByToken()* fetches the ConfirmationToken Object from the DB")
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
        //given
        String token = "token";
        ConfirmationToken unConfirmedUser =
                new ConfirmationToken(
                        100L, token, LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(15),
                        null,
                        null
                );
        confirmationTokenRepository.save(unConfirmedUser);

        //when
        ConfirmationToken ConfirmedUser = confirmationTokenRepository.findByToken(token).get();
        ConfirmedUser.setConfirmedAt(LocalDateTime.now());
        confirmationTokenRepository.save(ConfirmedUser);

        //then
        LocalDateTime confirmed_at = confirmationTokenRepository.findByToken(token).get().getConfirmedAt();
        assertNotNull(confirmed_at);
    }
}