package io.github.handsomecoder.utils;

public class ArrayUtils {

    private ArrayUtils(){}

    /**
     * @param strs
     * @param regex
     * @param replacement
     * @return
     * @author Harsh Shah
     */
    public static String[] replace(String[] strs, String regex, String replacement) {

        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].replaceAll(regex, replacement);
        }

        return strs;
    }
}
