package ru.itmo.s312198.devops.market.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


import java.util.HashSet;

@SpringBootTest
class OfferTest {

    Offer offer;

    @BeforeEach
    void setUp() {
        offer = new Offer();
        offer.setId(1);
        offer.setBuyer(2L);
        offer.setSalesman(3L);
        offer.setPrice(4);
        offer.setPublished("2025-05-25");
        offer.setStatus(1);
        offer.setItems(new HashSet<Item>());
    }

    @Test
    void getItems() {
        assertEquals(0, offer.getItems().size());
    }

    @Test
    void getId() {
        assertEquals(1, offer.getId());
    }

    @Test
    void getSalesman() {
        assertEquals(3, offer.getSalesman());
    }

    @Test
    void getBuyer() {
        assertEquals(2L, offer.getBuyer());
    }

    @Test
    void getPrice() {
        assertEquals(4, offer.getPrice());
    }

    @Test
    void getPublished() {
        assertEquals("2025-05-25", offer.getPublished());
    }

    @Test
    void getStatus() {
        assertEquals(1, offer.getStatus());
    }
}