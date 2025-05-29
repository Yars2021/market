package ru.itmo.s312198.devops.market.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationErrorTest {

    ApplicationError error;

    @BeforeEach
    void setUp() {
        error = new ApplicationError(HttpStatus.SERVICE_UNAVAILABLE, "error");
        error.setMessage("OK");
        error.setStatus(HttpStatus.OK);
    }

    @Test
    void getStatus() {
        assertEquals(HttpStatus.OK, error.getStatus());
    }

    @Test
    void getMessage() {
        assertEquals("OK", error.getMessage());
    }
}