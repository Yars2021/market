package ru.itmo.s312198.devops.market.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itmo.s312198.devops.market.data.User;
import ru.itmo.s312198.devops.market.exception.UserNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void findAll() {
        assertNotNull(userService);
        assertNotEquals(0, userService.findAll().size());
    }

    @Test
    void findByLogin() {
        assertNotNull(userService);
        assertThrows(UserNotFoundException.class, () -> {userService.findByLogin("yars81");});
    }

    @Test
    void delete() {
        assertNotNull(userService);
        assertThrows(UserNotFoundException.class, () -> {userService.delete("kjhgiuygkjh");});
    }

    @Test
    void createUser() {
        assertNotNull(userService);
        User user = new User();
        user.setLogin("kjhgiuygkjh");
        user.setName("yars");
        user.setPassword("yars");
        user.setBalance(0L);
        user.setReputationSeller(1);
        user.setReputationBuyer(2);
        userService.createUser(user);
    }

    @Test
    void updateUser() {
        assertNotNull(userService);
        User user = userService.findByLogin("yars");
        assertNotNull(user);
        user.setName("yars2");
        userService.updateUser(user);
    }
}