package ru.itmo.s312198.devops.market.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OfferRepositoryTest {
    @Autowired
    OfferRepository offerRepository;

    @Test
    void findBySalesman() {
        assertNotNull(offerRepository);
        assertEquals(2, offerRepository.findBySalesman(1L).size());
    }

    @Test
    void findByBuyer() {
        assertNotNull(offerRepository);
        assertEquals(2, offerRepository.findByBuyer(null).size());
    }

    @Test
    void findByStatus() {
        assertNotNull(offerRepository);
        assertEquals(0, offerRepository.findByStatus(null).size());
    }
}