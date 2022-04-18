package io.github.handsomecoder.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * The type String utils.
 *
 * @author Harsh Shah
 */
public class StringUtils {

    public static final String HASH_WITH_SHA_256 = "SHA-256";

    /**
     * @param str
     * @return
     * @author Harsh Shah
     */
    public static boolean isEmpty(String str) {
        return (str == null) ? true : str.trim().length() == 0;
    }

    /**
     * @param str
     * @return
     * @author Harsh Shah
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * @param strs
     * @return
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
     * @param strings
     * @return
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
     * @param values
     * @return
     * @author Harsh Shah
     */
    public static String builder(String... values) {

        StringBuilder builder = new StringBuilder();

        for (String value : values) {
            builder.append(value);
        }

        return builder.toString();
    }

    /**
     * @param value
     * @return
     * @author Harsh Shah
     */
    public static String valueOf(Object value) {
        return String.valueOf(value);
    }

    /**
     * @param str
     * @return
     * @author Harsh Shah
     */
    public static String getHash(String str, String algo) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(algo);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return bytesToHex(digest.digest(str.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * @param hash
     * @return
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
     * @param str
     * @param count
     * @return
     * @author Harsh Shah
     */
    public static String repeat(String str, int count) {
        return str.repeat(count);
    }

    /**
     * @param str
     * @param count
     * @param with
     * @return
     * @author Harsh Shah
     */
    public static String repeatAndJoin(String str, int count, String with) {

        List<String> strs = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            strs.add(str);
        }

        return join(with, strs);
    }

    /**
     * @param str
     * @param regex
     * @return
     */
    public static String[] splitAndTrim(String str, String regex) {
        String[] parts = str.split(regex);

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }

        return parts;
    }

    /**
     * @param str
     * @param regex
     * @param replacement
     * @return
     */
    public static String replace(String str, String regex, String replacement) {
        return str.replaceAll(regex, replacement);
    }

    /**
     * Join string.
     *
     * @param delimiter the delimiter
     * @param strs      the strs
     * @return string
     * @author Harsh Shah
     */
    public static String join(String delimiter, List<String> strs){

        if(strs == null || strs.isEmpty()){
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
