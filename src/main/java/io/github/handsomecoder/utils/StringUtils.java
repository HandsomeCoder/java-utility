package io.github.handsomecoder.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static io.github.handsomecoder.utils.ObjectUtils.isAnyNull;

/**
 * The type String utils.
 *
 * @author Harsh Shah
 */
public class StringUtils {

    /**
     * The constant HASH_WITH_SHA_256.
     */
    public static final String HASH_WITH_SHA_256 = "SHA-256";

    /**
     * Is empty boolean.
     *
     * @param str the str
     * @return boolean boolean
     * @author Harsh Shah
     */
    public static boolean isEmpty(String str) {
        return (str == null) ? true : str.trim().length() == 0;
    }

    /**
     * Is not empty boolean.
     *
     * @param str the str
     * @return boolean boolean
     * @author Harsh Shah
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * Is any empty boolean.
     *
     * @param strs the strs
     * @return boolean boolean
     * @author Harsh Shah
     */
    public static boolean isAnyEmpty(String... strs) {
        for (String str : strs) {
            if (isEmpty(str)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Is all empty boolean.
     *
     * @param strings the strings
     * @return boolean boolean
     * @author Harsh Shah
     */
    public static boolean isAllEmpty(String... strings) {
        for (String str : strings) {
            if (isNotEmpty(str)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Builder string.
     *
     * @param values the values
     * @return string string
     * @author Harsh Shah
     */
    public static String builder(String... values) {

        StringBuilder builder = new StringBuilder();

        for (String value : values) {

            if(isEmpty(value)){
                continue;
            }

            builder.append(value);
        }

        return builder.toString();
    }

    /**
     * Value of string.
     *
     * @param value the value
     * @return string string
     * @author Harsh Shah
     */
    public static String valueOf(Object value) {
        return String.valueOf(value);
    }

    /**
     * Gets hash.
     *
     * @param str  the str
     * @param algo the algo
     * @return hash hash
     * @author Harsh Shah
     */
    public static String getHash(String str, String algo) {

        if(isAnyNull(str, algo)){
            return null;
        }

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(algo);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return bytesToHex(digest.digest(str.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Bytes to hex string.
     *
     * @param hash the hash
     * @return string string
     */
    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * Repeat string.
     *
     * @param str   the str
     * @param count the count
     * @return string string
     * @author Harsh Shah
     */
    public static String repeat(String str, int count) {
        if(isAnyNull(str) || count < 0){
            return null;
        }

        return str.repeat(count);
    }

    /**
     * Repeat and join string.
     *
     * @param str   the str
     * @param count the count
     * @param with  the with
     * @return string string
     * @author Harsh Shah
     */
    public static String repeatAndJoin(String str, int count, String with) {

        if(isAnyNull(str, with) || count < 0){
            return null;
        }

        List<String> strs = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            strs.add(str);
        }

        return join(with, strs);
    }

    /**
     * Split and trim string [ ].
     *
     * @param str   the str
     * @param regex the regex
     * @return string [ ]
     */
    public static String[] splitAndTrim(String str, String regex) {

        if(isAnyNull(str, regex)){
            return null;
        }

        String[] parts = str.split(regex);

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }

        return parts;
    }

    /**
     * Replace string.
     *
     * @param str         the str
     * @param regex       the regex
     * @param replacement the replacement
     * @return string string
     */
    public static String replace(String str, String regex, String replacement) {
        if(isAnyNull(str, regex, replacement)){
            return null;
        }

        return str.replaceAll(regex, replacement);
    }

    /**
     * Join string.
     *
     * @param delimiter the delimiter
     * @param strs      the strs
     * @return string string
     * @author Harsh Shah
     */
    public static String join(String delimiter, List<String> strs){

        if(isAnyNull(delimiter, strs)){
            return null;
        }

        return strs.stream().collect(Collectors.joining(delimiter));
    }

    /**
     * Join string.
     *
     * @param delimiter the delimiter
     * @param strs      the strs
     * @return the string
     */
    public static String join(String delimiter, String... strs){
        return join(delimiter, Arrays.asList(strs));
    }
}
