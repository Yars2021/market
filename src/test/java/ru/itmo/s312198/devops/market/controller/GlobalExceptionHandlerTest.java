package ru.itmo.s312198.devops.market.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import ru.itmo.s312198.devops.market.exception.ItemNotFoundException;
import ru.itmo.s312198.devops.market.exception.OfferNotFoundException;
import ru.itmo.s312198.devops.market.exception.ServiceUnavailableException;
import ru.itmo.s312198.devops.market.exception.UserNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GlobalExceptionHandlerTest {

    UserNotFoundException unfe = new UserNotFoundException("unfe");
    ItemNotFoundException infe = new ItemNotFoundException("infe");
    OfferNotFoundException onfe = new OfferNotFoundException("onfe");
    ServiceUnavailableException sue = new ServiceUnavailableException("sue");

    GlobalExceptionHandler geh = new GlobalExceptionHandler();

    @Test
    void catchUserNotFoundExceptionTest() {
        assertEquals(HttpStatus.NOT_FOUND, geh.catchUserNotFoundException(unfe).getStatusCode());
    }

    @Test
    void catchItemNotFoundExceptionTest() {
        assertEquals(HttpStatus.NOT_FOUND, geh.catchItemNotFoundException(infe).getStatusCode());
    }

    @Test
    void catchOfferNotFoundExceptionTest() {
        assertEquals(HttpStatus.NOT_FOUND, geh.catchOfferNotFoundException(onfe).getStatusCode());
    }

    @Test
    void catchServiceUnavailableExceptionTest() {
        assertEquals(HttpStatus.SERVICE_UNAVAILABLE, geh.catchServiceUnavailableException(sue).getStatusCode());
    }
}

