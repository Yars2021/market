package ru.itmo.s312198.devops.market.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StatusRepositoryTest {

    @Autowired
    private StatusRepository statusRepository;

    @Test
    void findByStatus() {
        assertNotNull(statusRepository);
        assertEquals(1, statusRepository.findByStatus("Closed").getId());
    }
}