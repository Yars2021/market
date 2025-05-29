package ru.itmo.s312198.devops.market.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void findByLogin() {
        assertNotNull(userRepository);
        List<User> users = userRepository.findAll();
        assertNotEquals(0, users.size());
    }

    @Test
    void finByLoginTest() {
        assertNotNull(userRepository);
        assertEquals(111, userRepository.findByLogin("yars").getReputationSeller());
    }
}