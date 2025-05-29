package ru.itmo.s312198.devops.market.service;

import ru.itmo.s312198.devops.market.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.itmo.s312198.devops.market.data.User;
import ru.itmo.s312198.devops.market.data.UserRepository;
import ru.itmo.s312198.devops.market.util.HashPasswordEncoder;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);
    private final HashPasswordEncoder hashPasswordEncoder = new HashPasswordEncoder();

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByLogin(String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            logger.error("User with login '{}' not found. Nothing to delete.", login);
            throw new UserNotFoundException("User with login '" + login + "' not found.");
        } else {
            return user;
        }
    }

    public void delete(String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            logger.error("User with login '{}' not found. Nothing to delete.", login);
            throw new UserNotFoundException("User with login '" + login + "' not found.");
        } else {
            userRepository.delete(user);
        }
    }

    public User createUser(User user) {
        user.setPassword(hashPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User lu = userRepository.findByLogin(user.getLogin());
        if (lu == null) {
            logger.error("User with login '{}' not found. Nothing to update.", user.getLogin());
            throw new UserNotFoundException("User with login '" + user.getLogin() + "' not found.");
        } else {
            lu.setLogin(user.getLogin());
            lu.setPassword(hashPasswordEncoder.encode(user.getPassword()));
            lu.setName(user.getName());
            lu.setBalance(user.getBalance());
            lu.setReputationBuyer(user.getReputationBuyer());
            lu.setReputationSeller(user.getReputationSeller());
            return userRepository.save(lu);
        }
    }
}
