package io.github.handsomecoder.utils;

/**
 * The type Array utils.
 */
public class ArrayUtils {

    private ArrayUtils(){}

    /**
     * Replace string [ ].
     *
     * @param strs        the strs
     * @param regex       the regex
     * @param replacement the replacement
     * @return string [ ]
     * @author Harsh Shah
     */
    public static String[] replace(String[] strs, String regex, String replacement) {

        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].replaceAll(regex, replacement);
        }

        return strs;
    }
}
