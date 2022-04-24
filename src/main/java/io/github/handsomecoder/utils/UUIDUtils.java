package io.github.handsomecoder.utils;

import java.util.UUID;

/**
 * The type Uuid utils.
 *
 * @author Harsh Shah
 */
public class UUIDUtils {

    private UUIDUtils() {
    }

    /**
     * Generate string.
     *
     * @return string string
     * @author Harsh Shah
     */
    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
