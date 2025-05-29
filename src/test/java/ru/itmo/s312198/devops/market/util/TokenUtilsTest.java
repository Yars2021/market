package ru.itmo.s312198.devops.market.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenUtilsTest {

    @Test
    void getToken() {
        TokenUtils tokenUtils = new TokenUtils();
        assertNotNull(tokenUtils.getToken());
    }
}