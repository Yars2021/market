package ru.itmo.s312198.devops.market.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


import java.util.HashSet;

@SpringBootTest
class ItemTest {

    Item item;

    @BeforeEach
    void setUp() {
        item = new Item();
        item.setId(1);
        item.setType(2);
        item.setOwner(3L);
        item.setName("test");
        item.setRarity(4);
        item.setDescription("TEST");
        item.setOffers(new HashSet<Offer>());
    }

    @Test
    void getId() {
        assertEquals(1, item.getId());
    }

    @Test
    void getType() {
        assertEquals(2, item.getType());
    }
  
    @Test
    void getOwner() {
        assertEquals(3L, item.getOwner());
    }

    @Test
    void getName() {
        assertEquals("test", item.getName());
    }

    @Test
    void getRarity() {
        assertEquals(4, item.getRarity());
    }

    @Test
    void getDescription() {
        assertEquals("TEST", item.getDescription());
    }

    @Test
    void getOffers() {
        assertEquals(0, item.getOffers().size());
    }
}
