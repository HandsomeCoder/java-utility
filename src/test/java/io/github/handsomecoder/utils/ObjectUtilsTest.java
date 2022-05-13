package io.github.handsomecoder.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.github.handsomecoder.constant.ApplicationConstant.EMPTY_STRING;
import static io.github.handsomecoder.utils.ObjectUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The type Object utils test.
 */
class ObjectUtilsTest {

    /**
     * Test is null datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testIsNullDatasource() {
        return Stream.of(
                Arguments.of(false, "sample"),
                Arguments.of(true, null),
                Arguments.of(false, EMPTY_STRING),
                Arguments.of(false, 0),
                Arguments.of(false, false)
        );
    }

    /**
     * Test is not null datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testIsNotNullDatasource() {
        return Stream.of(
                Arguments.of(true, "sample"),
                Arguments.of(false, null),
                Arguments.of(true, EMPTY_STRING),
                Arguments.of(true, 0),
                Arguments.of(true, false)
        );
    }

    /**
     * Test is any null datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testIsAnyNullDatasource() {
        return Stream.of(
                Arguments.of(false, new Object[]{"abc", 1, EMPTY_STRING, false}),
                Arguments.of(true, new Object[]{null, "abc", EMPTY_STRING}),
                Arguments.of(false, new Object[]{EMPTY_STRING, EMPTY_STRING, EMPTY_STRING}),
                Arguments.of(false, new Object[]{0, 0, 0}),
                Arguments.of(true, new Object[]{"abc", EMPTY_STRING, null})
        );
    }

    /**
     * Test is all null datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testIsAllNullDatasource() {
        return Stream.of(
                Arguments.of(false, new Object[]{"abc", 1, EMPTY_STRING, false}),
                Arguments.of(true, new Object[]{null, null, null}),
                Arguments.of(false, new Object[]{EMPTY_STRING, EMPTY_STRING, EMPTY_STRING}),
                Arguments.of(false, new Object[]{EMPTY_STRING, null, EMPTY_STRING}),
                Arguments.of(false, new Object[]{0, 0, 0}),
                Arguments.of(false, new Object[]{false, false, false}),
                Arguments.of(false, new Object[]{null, false, false})
        );
    }

    /**
     * Test is all not null datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testIsAllNotNullDatasource() {
        return Stream.of(
                Arguments.of(true, new Object[]{"abc", 1, EMPTY_STRING, false}),
                Arguments.of(false, new Object[]{null, null, null}),
                Arguments.of(true, new Object[]{EMPTY_STRING, EMPTY_STRING, EMPTY_STRING}),
                Arguments.of(false, new Object[]{EMPTY_STRING, null, EMPTY_STRING}),
                Arguments.of(true, new Object[]{0, 0, 0}),
                Arguments.of(true, new Object[]{false, false, false}),
                Arguments.of(false, new Object[]{null, false, false})
        );
    }

    /**
     * Test is instance datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testIsInstanceDatasource() {
        return Stream.of(
                Arguments.of(true, "String", String.class),
                Arguments.of(false, "String", Boolean.class),
                Arguments.of(true, true, Boolean.class),
                Arguments.of(false, null, String.class),
                Arguments.of(true, 0, Integer.class)
        );
    }

    /**
     * Test require non null datasource stream.
     *
     * @return the stream
     * @author Harsh Shah
     */
    public static Stream<Arguments> testRequireNonNullDatasource() {
        return Stream.of(
                Arguments.of("String", "String"),
                Arguments.of(false, false),
                Arguments.of(0, 0),
                Arguments.of(null, null)
        );
    }

    /**
     * Test is null.
     *
     * @param expected the expected
     * @param object   the object
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testIsNull() = {1}")
    @MethodSource("testIsNullDatasource")
    void testIsNull(boolean expected, Object object) {
        assertEquals(expected, isNull(object));
    }

    /**
     * Test is not null.
     *
     * @param expected the expected
     * @param object   the object
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testIsNotNull() = {1}")
    @MethodSource("testIsNotNullDatasource")
    void testIsNotNull(boolean expected, Object object) {
        assertEquals(expected, isNotNull(object));
    }

    /**
     * Test is any null.
     *
     * @param expected the expected
     * @param objects  the objects
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testIsAnyNull() = {0}")
    @MethodSource("testIsAnyNullDatasource")
    void testIsAnyNull(boolean expected, Object... objects) {
        assertEquals(expected, isAnyNull(objects));
    }

    /**
     * Test is all null.
     *
     * @param expected the expected
     * @param objects  the objects
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testIsAllNull() = {0}")
    @MethodSource("testIsAllNullDatasource")
    void testIsAllNull(boolean expected, Object... objects) {
        assertEquals(expected, isAllNull(objects));
    }

    /**
     * Test is all not null.
     *
     * @param expected the expected
     * @param objects  the objects
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testIsAllNotNull() = {0}")
    @MethodSource("testIsAllNotNullDatasource")
    void testIsAllNotNull(boolean expected, Object... objects) {
        assertEquals(expected, isAllNotNull(objects));
    }

    /**
     * Test is instance.
     *
     * @param <T>      the type parameter
     * @param expected the expected
     * @param object   the object
     * @param tClass   the t class
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testIsInstance() = {0}")
    @MethodSource("testIsInstanceDatasource")
    <T> void testIsInstance(boolean expected, Object object, Class<T> tClass) {
        assertEquals(expected, isInstance(object, tClass));
    }

    /**
     * Test require non null.
     *
     * @param object the object
     * @author Harsh Shah
     */
    @ParameterizedTest(name = "{index}: testRequireNonNull() = {0}")
    @MethodSource("testRequireNonNullDatasource")
    void testRequireNonNull(Object object) {
        if (isNull(object)) {
            assertThrows(NullPointerException.class, () -> requireNonNull(object));
        } else {
            assertEquals(object, requireNonNull(object));
        }
    }
}