package io.github.handsomecoder.utils;

import java.util.List;

import static io.github.handsomecoder.utils.StringUtils.repeat;
import static io.github.handsomecoder.utils.StringUtils.repeatAndJoin;
import static java.lang.String.format;

/**
 * @author Harsh Shah
 */
public class PrintUtils {

    private PrintUtils() {
    }

    /**
     * @param message
     * @author Harsh Shah
     */
    public static void print(String message) {
        System.out.print(message);
    }

    /**
     * @param message
     * @author Harsh Shah
     */
    public static void println(String message) {
        System.out.println(message);
    }

    /**
     * @param message
     * @author Harsh Shah
     */
    public static void withMargin(String message) {
        System.out.println();
        println(message);
        System.out.println();
    }

    /**
     * @param messages
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
     * @param message
     * @author Harsh Shah
     */
    public static void success(String message) {
        withMargin("\u2714 " + message);
    }

    /**
     * @param message
     * @param values
     * @author Harsh Shah
     */
    public static void success(String message, Object... values) {
        success(format(message, values));
    }

    /**
     * @param message
     * @author Harsh Shah
     */
    public static void error(String message) {
        withMargin("\u2716 " + message);
    }

    /**
     * @param message
     * @param values
     * @author Harsh Shah
     */
    public static void error(String message, Object... values) {
        error(format(message, values));
    }

    /**
     * @param headers
     * @param matrix
     * @author Harsh Shah
     */
    public static void printMatrix(List<String> headers, List<List<Object>> matrix) {
        println("");
        println(format(repeatAndJoin("  %15s  ", headers.size(), "|"), headers.toArray()));
        println(repeat("-", (19 * headers.size()) + headers.size() - 1));
        for (List<Object> row : matrix) {
            println(format(repeatAndJoin("  %15s  ", headers.size(), "|"), row.toArray()));
        }
        println("");
    }
}
