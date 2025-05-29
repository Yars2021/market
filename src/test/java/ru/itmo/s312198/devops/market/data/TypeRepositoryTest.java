package ru.itmo.s312198.devops.market.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TypeRepositoryTest {
    @Autowired
    TypeRepository typeRepository;

    @Test
    void findByType() {
        assertNotNull(typeRepository);
        assertEquals(1, typeRepository.findByType("Melee").getId());
    }
}