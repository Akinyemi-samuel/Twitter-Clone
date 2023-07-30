package com.samuel.repository;

import com.samuel.enums.Role;
import com.samuel.model.User;
import org.junit.jupiter.api.AfterEach;
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
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void findByEmail() {
        //given
        User user = new User(
                100L, "samuelayo@gmail.com",
                "Akinyemi samuel", LocalDateTime.now(),
                null,
                Role.USER);
        userRepository.save(user);

        //when
        User expectedUser = userRepository.findByEmail(user.getEmail()).get();

        //then
        assertNotNull(expectedUser);
        assertEquals(user, expectedUser);
    }

    @Test
    void updatePasswordById() {
        //given
        User user = new User(
                100L, "samuelayo@gmail.com",
                "Akinyemi samuel", LocalDateTime.now(),
                null,
                Role.USER);
        userRepository.save(user);

        //when
        User updatedUser = userRepository.findById(user.getUserId()).get();
        String newPassword = "sammy";
        updatedUser.setPassword(newPassword);
        userRepository.save(updatedUser);

        //then
        assertNotNull(updatedUser);
        assertEquals(user.getUserId(), updatedUser.getUserId());
        assertEquals(newPassword, updatedUser.getPassword());
    }
}