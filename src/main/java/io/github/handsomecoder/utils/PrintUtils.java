package io.github.handsomecoder.utils;

import com.google.errorprone.annotations.FormatMethod;
import com.google.errorprone.annotations.FormatString;

import java.util.List;
import java.util.Objects;

import static io.github.handsomecoder.utils.ObjectUtils.requireNonNull;
import static io.github.handsomecoder.utils.StringUtils.repeat;
import static io.github.handsomecoder.utils.StringUtils.repeatAndJoin;
import static java.lang.String.format;

/**
 * The type Print utils.
 *
 * @author Harsh Shah
 */
public class PrintUtils {

    private PrintUtils() {
    }

    /**
     * Print.
     *
     * @param message the message
     * @author Harsh Shah
     */
    public static void print(String message) {
        System.out.print(message);
    }

    /**
     * Println.
     *
     * @param message the message
     * @author Harsh Shah
     */
    public static void println(String message) {
        System.out.println(message);
    }

    /**
     * With margin.
     *
     * @param message the message
     * @author Harsh Shah
     */
    public static void withMargin(String message) {
        System.out.println();
        println(message);
        System.out.println();
    }

    /**
     * With margin.
     *
     * @param messages the messages
     * @author Harsh Shah
     */
    public static void withMargin(String... messages) {
        System.out.println();
        for (String message : messages) {
            println(message);
        }
        System.out.println();
    }

    /**
     * Success.
     *
     * @param message the message
     * @author Harsh Shah
     */
    public static void success(String message) {
        withMargin("\u2714 " + message);
    }

    /**
     * Success.
     *
     * @param message the message
     * @param values  the values
     * @author Harsh Shah
     */
    @FormatMethod
    public static void success(@FormatString String message, Object... values) {
        success(format(message, values));
    }

    /**
     * Error.
     *
     * @param message the message
     * @author Harsh Shah
     */
    public static void error(String message) {
        withMargin("\u2716 " + message);
    }

    /**
     * Error.
     *
     * @param message the message
     * @param values  the values
     * @author Harsh Shah
     */
    @FormatMethod
    public static void error(@FormatString String message, Object... values) {
        error(format(message, values));
    }

    /**
     * Print matrix.
     *
     * @param headers the headers
     * @param matrix  the matrix
     * @author Harsh Shah
     */
    public static void printMatrix(List<String> headers, List<List<Object>> matrix) {
        println("");
        println(format(requireNonNull(repeatAndJoin("  %15s  ", headers.size(), "|")), headers.toArray()));
        println(repeat("-", (19 * headers.size()) + headers.size() - 1));
        for (List<Object> row : matrix) {
            println(format(requireNonNull(repeatAndJoin("  %15s  ", headers.size(), "|")), row.toArray()));
        }
        println("");
    }
}
