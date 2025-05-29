package ru.itmo.s312198.devops.market.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RarityRepositoryTest {

    @Autowired
    RarityRepository rarityRepository;

    @Test
    void findByRarity() {
        assertNotNull(rarityRepository);
        assertEquals(3, rarityRepository.findByRarity("Exclusive").getId());
    }
}