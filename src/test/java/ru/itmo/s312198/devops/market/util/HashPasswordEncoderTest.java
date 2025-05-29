package ru.itmo.s312198.devops.market.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashPasswordEncoderTest {

    @Test
    void encode() {
        HashPasswordEncoder encoder = new HashPasswordEncoder();
        assertEquals("24e49fb349b9894d1ba891fd328698ba02ae25e758251dd67e076499ce8230d3", encoder.encode("yars"));
    }
}