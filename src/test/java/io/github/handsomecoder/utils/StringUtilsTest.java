package io.github.handsomecoder.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.github.handsomecoder.constant.ApplicationConstant.BLANK_SPACE;
import static io.github.handsomecoder.constant.ApplicationConstant.EMPTY_STRING;
import static io.github.handsomecoder.utils.StringUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The type String utils test.
 */
class StringUtilsTest {

    /**
     * Test is not empty datasource stream.
     *
     * @return stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testIsNotEmptyDatasource() {
        return Stream.of(
                Arguments.of("sample", true),
                Arguments.of(null, false),
                Arguments.of(EMPTY_STRING, false),
                Arguments.of("   ", false)
        );
    }

    /**
     * Test is empty datasource stream.
     *
     * @return stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testIsEmptyDatasource() {
        return Stream.of(
                Arguments.of("sample", false),
                Arguments.of(null, true),
                Arguments.of(EMPTY_STRING, true),
                Arguments.of("   ", true)
        );
    }

    /**
     * Test is any empty datasource stream.
     *
     * @return stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testIsAnyEmptyDatasource() {
        return Stream.of(
                Arguments.of(false, new String[]{"sample1", "sample2", "3", "@"}),
                Arguments.of(true, new String[]{"sample1", "", "3", "@"}),
                Arguments.of(true, new String[]{"sample1", "sample2", null, "@"}),
                Arguments.of(true, new String[]{"sample1", "sample2", "3", "   "})
        );
    }

    /**
     * Test is all empty datasource stream.
     *
     * @return the stream
     */
    public static Stream<Arguments> testIsAllEmptyDatasource() {
        return Stream.of(
                Arguments.of(true, new String[]{EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING}),
                Arguments.of(true, new String[]{EMPTY_STRING, null, BLANK_SPACE, EMPTY_STRING}),
                Arguments.of(true, new String[]{BLANK_SPACE, BLANK_SPACE, null, BLANK_SPACE}),
                Arguments.of(false, new String[]{"sample1", null, "3", "@3"}),
                Arguments.of(false, new String[]{"sample1", BLANK_SPACE, "3", "@3"}),
                Arguments.of(false, new String[]{"sample1", EMPTY_STRING, "3", "@3"}),
                Arguments.of(false, new String[]{"sample1", "EMPTY_STRING", "3", "@3"})
        );
    }

    /**
     * Test value of datasource stream.
     *
     * @return the stream
     */
    public static Stream<Arguments> testValueOfDatasource() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("1.1", 1.1),
                Arguments.of("true", true)
        );
    }

    /**
     * Test is not empty.
     *
     * @param str      the str
     * @param expected the expected
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testIsNotEmpty({0}) = {1}")
    @MethodSource("testIsNotEmptyDatasource")
    void testIsNotEmpty(String str, boolean expected) {
        assertEquals(expected, isNotEmpty(str));
    }

    /**
     * Test is empty.
     *
     * @param str      the str
     * @param expected the expected
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testIsEmpty({0}) = {1}")
    @MethodSource("testIsEmptyDatasource")
    void testIsEmpty(String str, boolean expected) {
        assertEquals(expected, isEmpty(str));
    }

    /**
     * Test is any empty.
     *
     * @param expected the expected
     * @param str      the str
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testIsAnyEmpty() = {0}")
    @MethodSource("testIsAnyEmptyDatasource")
    void testIsAnyEmpty(boolean expected, String... str) {
        assertEquals(expected, isAnyEmpty(str));
    }

    /**
     * Test is all empty.
     *
     * @param expected the expected
     * @param str      the str
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testIsAllEmpty() = {0}")
    @MethodSource("testIsAllEmptyDatasource")
    void testIsAllEmpty(boolean expected, String... str) {
        assertEquals(expected, isAllEmpty(str));
    }

    /**
     * Test value of.
     *
     * @param expected the expected
     * @param str      the str
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testValueOf() = {0}")
    @MethodSource("testValueOfDatasource")
    void testValueOf(String expected, Object str) {
        assertEquals(expected, valueOf(str));
    }

}