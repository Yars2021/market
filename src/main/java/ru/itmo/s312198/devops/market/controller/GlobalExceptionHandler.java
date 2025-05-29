package ru.itmo.s312198.devops.market.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.itmo.s312198.devops.market.exception.ItemNotFoundException;
import ru.itmo.s312198.devops.market.exception.OfferNotFoundException;
import ru.itmo.s312198.devops.market.exception.ServiceUnavailableException;
import ru.itmo.s312198.devops.market.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchUserNotFoundException(UserNotFoundException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(new ApplicationError(HttpStatus.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchItemNotFoundException(ItemNotFoundException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(new ApplicationError(HttpStatus.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchOfferNotFoundException(OfferNotFoundException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(new ApplicationError(HttpStatus.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchServiceUnavailableException(ServiceUnavailableException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(new ApplicationError(HttpStatus.SERVICE_UNAVAILABLE, e.getMessage()), HttpStatus.SERVICE_UNAVAILABLE);
    }
}