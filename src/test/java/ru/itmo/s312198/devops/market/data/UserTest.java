package ru.itmo.s312198.devops.market.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setPassword("password");
        user.setLogin("login");
        user.setName("name");
        user.setBalance(1L);
        user.setReputationBuyer(2);
        user.setReputationSeller(3);
    }

    @Test
    void getLogin() {
        assertEquals("login", user.getLogin());
    }

    @Test
    void getPassword() {
        assertEquals("password", user.getPassword());
    }

    @Test
    void getName() {
        assertEquals("name", user.getName());
    }

    @Test
    void getBalance() {
        assertEquals(1L, user.getBalance());
    }

    @Test
    void getReputationSeller() {
        assertEquals(3, user.getReputationSeller());
    }

    @Test
    void getReputationBuyer() {
        assertEquals(2, user.getReputationBuyer());
    }
}