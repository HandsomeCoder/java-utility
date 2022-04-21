package io.github.handsomecoder.utils;

import org.junit.jupiter.api.Test;

import static io.github.handsomecoder.constant.ApplicationConstant.EMPTY_STRING;
import static org.junit.jupiter.api.Assertions.*;

class UUIDUtilsTest {

    @Test
    void generate() {
        String uuid = UUIDUtils.generate();
        assertNotNull(uuid);
        assertNotEquals(uuid, EMPTY_STRING);
    }
}