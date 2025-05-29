package ru.itmo.s312198.devops.market.controller;

import org.springframework.http.HttpStatus;

public class ApplicationError {
    HttpStatus status;
    String message;

    public ApplicationError() {
    }

    public ApplicationError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
