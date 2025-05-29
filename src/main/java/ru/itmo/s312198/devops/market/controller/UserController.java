package ru.itmo.s312198.devops.market.controller;

import ru.itmo.s312198.devops.market.exception.ServiceUnavailableException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.s312198.devops.market.data.User;
import ru.itmo.s312198.devops.market.service.UserService;

import java.util.List;

@RestController
public class UserController{
    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        logger.info("Getting all users");
        if (userService == null) {
            throw new ServiceUnavailableException("UserService is null");
        } else {
            List<User> users = userService.findAll();
            users.forEach(u -> u.setPassword(""));
            return users;
        }
    }

    @GetMapping(value = "/users/{login}")
    public User getUser(@PathVariable String login) {
        logger.info("Getting user with login '{}'", login);
        if (userService == null) {
            throw new ServiceUnavailableException("UserService is null");
        } else {
            User user = userService.findByLogin(login);
            HttpStatus status = user == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
            if (user !=null) {
                user.setPassword("");
            }
            return userService.findByLogin(login);
        }
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        logger.info("Creating new user");
        if (userService == null) {
            throw new ServiceUnavailableException("UserService is null");
        } else {
            return userService.createUser(user);
        }
    }

    @DeleteMapping("/users/{login}")
    public void deleteUser(@PathVariable String login) {
        logger.info("Deleting user with login '{}'", login);
        if (userService == null) {
            throw new ServiceUnavailableException("UserService is null");
        } else {
            userService.delete(login);
        }
    }

    @PutMapping("/users/{login}")
    public User updateUser(@PathVariable String login,@RequestBody User user) {
        logger.info("Updating user with login '{}'", login);
        if (userService == null) {
            throw new ServiceUnavailableException("UserService is null");
        } else {
            user.setLogin(login);
            userService.updateUser(user);
        }
        return user;
    }
}
