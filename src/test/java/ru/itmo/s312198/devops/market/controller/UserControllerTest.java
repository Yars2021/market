package ru.itmo.s312198.devops.market.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itmo.s312198.devops.market.data.User;
import ru.itmo.s312198.devops.market.exception.ServiceUnavailableException;
import ru.itmo.s312198.devops.market.exception.UserNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    @Autowired
    UserController userController;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getAllUsers() {
        assertNotNull(userController);
        assertNotEquals(0, userController.getAllUsers().size());
    }

    @Test
    void getUser() {
        assertNotNull(userController);
        assertEquals(111, userController.getUser("yars").getReputationSeller());
    }

    @Test
    void createUser() {
        assertNotNull(userController);
        User user = new User();
        user.setLogin("u1");
        user.setPassword("p1");
        user.setName("n1");
        user.setBalance(1L);
        user.setReputationBuyer(2);
        user.setReputationSeller(3);
        assertNotNull(userController.createUser(user));
    }

    @Test
    void deleteUser() {
        assertThrows(UserNotFoundException.class, () -> userController.deleteUser("u245"));
    }

    @Test
    void updateUser() {
        assertNotNull(userController);
        User user = userController.getUser("ja_vani");
        assertNotNull(user);
        user.setName("ja_vani2");
        userController.updateUser("ja_vani", user);
    }
}