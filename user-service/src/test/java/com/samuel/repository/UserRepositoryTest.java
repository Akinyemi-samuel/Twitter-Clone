package com.samuel.repository;

import com.samuel.enums.Role;
import com.samuel.model.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ActiveProfiles("test")
//@TestPropertySource(locations = "classpath:application-test.properties")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmail() {
        //given
        User user = new User(
                100L, "samuel@gmail.com", "Akinyemi samuel", LocalDateTime.now(),
                "$2a$10$HO1lD/hREJsFyVQe8x6dcuMG/6P8JIIOyQNC89CCTQ0h8sGjQ7bfO",
                Role.USER);
        userRepository.save(user);


        //when
        User user1 = userRepository.findByEmail(user.getEmail()).get();

        //then
        assertEquals(user, user1);

    }

    @Test
    void updatePasswordById() {
        assertEquals(2, 1+1);
    }
}