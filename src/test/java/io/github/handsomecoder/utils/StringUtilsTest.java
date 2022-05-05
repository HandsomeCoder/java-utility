package io.github.handsomecoder.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static io.github.handsomecoder.constant.ApplicationConstant.*;
import static io.github.handsomecoder.utils.StringUtils.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type String utils test.
 */
class StringUtilsTest {

    /**
     * Test is not empty datasource stream.
     *
     * @return stream stream
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
     * @return stream stream
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
     * @return stream stream
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
     * @author Harsh Shah
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
     * @author Harsh Shah
     */
    public static Stream<Arguments> testValueOfDatasource() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("1.1", 1.1),
                Arguments.of("true", true)
        );
    }

    /**
     * Test join datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testJoinDatasource() {
        return Stream.of(
                Arguments.of(null, null, new String[]{EMPTY_STRING, EMPTY_STRING, EMPTY_STRING}),
                Arguments.of(EMPTY_STRING, EMPTY_STRING, new String[]{}),
                Arguments.of(EMPTY_STRING, EMPTY_STRING, new String[]{EMPTY_STRING, EMPTY_STRING, EMPTY_STRING}),
                Arguments.of("lorem,EMPTY_STRING,3", ",", new String[]{"lorem", "EMPTY_STRING", "3"}),
                Arguments.of("lorem,null,3", ",", new String[]{"lorem", null, "3"}),
                Arguments.of("sample1   3", BLANK_SPACE, new String[]{"sample1", BLANK_SPACE, "3"})
        );
    }

    /**
     * Test replace datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testReplaceDatasource() {
        return Stream.of(
                Arguments.of(null, null, EMPTY_STRING, "12345"),
                Arguments.of("12345s12345a12345m12345p12345l12345e12345", "sample", EMPTY_STRING, "12345"),
                Arguments.of("sample", "s@mple", "@", "a"),
                Arguments.of("What a day!", "Wh@t @ d@y!", "@", "a")
        );
    }

    /**
     * Test split and trim datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testSplitAndTrimDatasource() {
        return Stream.of(
                Arguments.of(null, null, null),
                Arguments.of(null, "1,2,3,4,5", null),
                Arguments.of(null, null, COMMA),
                Arguments.of(new String[]{EMPTY_STRING}, EMPTY_STRING, EMPTY_STRING),
                Arguments.of(new String[]{"s", "a", "m", "p", "l", "e"}, "sample", EMPTY_STRING),
                Arguments.of(new String[]{EMPTY_STRING}, EMPTY_STRING, COMMA),
                Arguments.of(new String[]{"1", "2", "3", "4", "5"}, "1,2,3,4,5", COMMA),
                Arguments.of(new String[]{"1", "2", "3", "4", "5"}, " 1, 2, 3, 4, 5 ", COMMA),
                Arguments.of(new String[]{"1", "", "2", "3", "4", "5"}, "1,,2,3,4,5", COMMA)
        );
    }

    /**
     * Test builder datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testBuilderDatasource() {
        return Stream.of(
                Arguments.of(EMPTY_STRING, new String[]{null, null}),
                Arguments.of(EMPTY_STRING, new String[]{EMPTY_STRING, EMPTY_STRING, EMPTY_STRING}),
                Arguments.of("sample", new String[]{EMPTY_STRING, "sample", null})

        );
    }

    /**
     * Test get hash datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testGetHashDatasource() {
        return Stream.of(
                Arguments.of(null, null, null),
                Arguments.of(null, EMPTY_STRING, null),
                Arguments.of(null, null, HASH_WITH_SHA_256),
                Arguments.of(null, EMPTY_STRING, EMPTY_STRING),
                Arguments.of(null, "sample", EMPTY_STRING),
                Arguments.of("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
                        EMPTY_STRING, HASH_WITH_SHA_256),
                Arguments.of("af2bdbe1aa9b6ec1e2ade1d694f41fc71a831d0268e9891562113d8a62add1bf", "sample", HASH_WITH_SHA_256)
        );
    }

    /**
     * Test repeat datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testRepeatDatasource() {
        return Stream.of(
                Arguments.of(null, null, 0),
                Arguments.of(EMPTY_STRING, EMPTY_STRING, 0),
                Arguments.of(EMPTY_STRING, EMPTY_STRING, 1),
                Arguments.of(EMPTY_STRING, EMPTY_STRING, 5),
                Arguments.of(EMPTY_STRING, "abc", 0),
                Arguments.of("abc", "abc", 1),
                Arguments.of("abcabcabcabcabc", "abc", 5)
        );
    }

    /**
     * Test repeat and join datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testRepeatAndJoinDatasource() {
        return Stream.of(
                Arguments.of(null, null, 0, null),
                Arguments.of(null, "abc", 0, null),
                Arguments.of(null, "abc", -1, null),
                Arguments.of(null, "abc", -1, BLANK_SPACE),
                Arguments.of(EMPTY_STRING, EMPTY_STRING, 0, EMPTY_STRING),
                Arguments.of(EMPTY_STRING, EMPTY_STRING, 1, EMPTY_STRING),
                Arguments.of(EMPTY_STRING, EMPTY_STRING, 5, EMPTY_STRING),
                Arguments.of(EMPTY_STRING, "abc", 0, EMPTY_STRING),
                Arguments.of("abc", "abc", 1, EMPTY_STRING),
                Arguments.of("abcabcabcabcabc", "abc", 5, EMPTY_STRING),
                Arguments.of("abc@abc@abc@abc@abc", "abc", 5, "@"),
                Arguments.of("abc,abc", "abc", 2, COMMA)
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

    /**
     * Test join with varargs.
     *
     * @param expected  the expected
     * @param delimiter the delimiter
     * @param strs      the strs
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testJoinWithVarargs() = {0}")
    @MethodSource("testJoinDatasource")
    void testJoinWithVarargs(String expected, String delimiter, String[] strs) {
        assertEquals(expected, join(delimiter, strs));
    }

    /**
     * Test join with list.
     *
     * @param expected  the expected
     * @param delimiter the delimiter
     * @param strs      the strs
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testJoinWithList() = {0}")
    @MethodSource("testJoinDatasource")
    void testJoinWithList(String expected, String delimiter, String[] strs) {
        assertEquals(expected, join(delimiter, Arrays.asList(strs)));
    }

    /**
     * Test replace.
     *
     * @param expected the expected
     * @param str      the str
     * @param replace  the replace
     * @param with     the with
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testReplace() = {0}")
    @MethodSource("testReplaceDatasource")
    void testReplace(String expected, String str, String replace, String with) {
        assertEquals(expected, replace(str, replace, with));
    }

    /**
     * Test split and trim.
     *
     * @param expected the expected
     * @param str      the str
     * @param with     the with
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testSplitAndTrim() = {0}")
    @MethodSource("testSplitAndTrimDatasource")
    void testSplitAndTrim(String[] expected, String str, String with) {
        assertArrayEquals(expected, splitAndTrim(str, with));
    }

    /**
     * Test builder.
     *
     * @param expected the expected
     * @param str      the str
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testBuilder() = {0}")
    @MethodSource("testBuilderDatasource")
    void testBuilder(String expected, String[] str) {
        assertEquals(expected, builder(str));
    }

    /**
     * Test get hash.
     *
     * @param expected the expected
     * @param str      the str
     * @param algo     the algo
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testGetHash() = {0}")
    @MethodSource("testGetHashDatasource")
    void testGetHash(String expected, String str, String algo) {
        assertEquals(expected, getHash(str, algo));
    }

    /**
     * Test repeat.
     *
     * @param expected the expected
     * @param str      the str
     * @param cnt      the cnt
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testRepeat() = {0}")
    @MethodSource("testRepeatDatasource")
    void testRepeat(String expected, String str, Integer cnt) {
        assertEquals(expected, repeat(str, cnt));
    }

    /**
     * Test repeat and join.
     *
     * @param expected the expected
     * @param str      the str
     * @param cnt      the cnt
     * @param with     the with
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testRepeatAndJoin() = {0}")
    @MethodSource("testRepeatAndJoinDatasource")
    void testRepeatAndJoin(String expected, String str, Integer cnt, String with) {
        assertEquals(expected, repeatAndJoin(str, cnt, with));
    }

}