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

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @AfterEach
    void setUp(){
        userRepository.deleteAll();
    }

    @Test
    void findByEmail() {
        User user = new User(
                100L, "samuel@gmail.com",
                "Akinyemi samuel", LocalDateTime.now(),
                null,
                Role.USER);
        userRepository.save(user);

//        User user1 = userRepository.findByEmail(user.getEmail()).get();
//
//        assertEquals(user1, user);
    }

    @Test
    void updatePasswordById() {
    }
}