package io.github.handsomecoder.utils.json;

import java.util.*;

/**
 * The type Json parser.
 *
 * @author Harsh Shah
 */
public class JsonParser {

    private static final Character OPENING_CURLY_BRACKET = '{';
    private static final Character CLOSING_CURLY_BRACKET = '}';
    private static final Character OPENING_SQUARE_BRACKET = '[';
    private static final Character CLOSING_SQUARE_BRACKET = ']';
    private static final Character DOUBLE_QUOTE = '"';
    private static final Character COLON = ':';
    private static final Character COMMA = ',';
    private static final Character BACKSLASH = '\\';

    private JsonParser() {
    }

    /**
     * Find opening closing brackets map.
     *
     * @param jsonString the json string
     * @return map map
     * @author Harsh Shah
     */
    public static Map<Integer, Integer> findOpeningClosingBrackets(String jsonString) {

        Map<Integer, Integer> result = new HashMap<>();
        char[] characters = jsonString.toCharArray();
        Stack<ClosingCharacterModel> stack = new Stack<>();

        for (int i = 0; i < characters.length; i++) {

            if (characters[i] == DOUBLE_QUOTE) {
                // skip the double quote
                i++;

                // skip all the characters between starting and ending double quotes
                while (!(characters[i] == DOUBLE_QUOTE &&
                        (i == 0 || characters[i - 1] != BACKSLASH))) {
                    i++;
                }
            } else if (characters[i] == OPENING_CURLY_BRACKET) {
                stack.push(new ClosingCharacterModel(CLOSING_CURLY_BRACKET, i));
                result.put(i, -1);
            } else if (characters[i] == OPENING_SQUARE_BRACKET && (i == 0 || characters[i - 1] == COLON)) {
                stack.push(new ClosingCharacterModel(CLOSING_SQUARE_BRACKET, i));
                result.put(i, -1);
            } else if (characters[i] == stack.peek().getCharacter()) {
                result.put(stack.pop().getIndex(), i);
            }
        }

        return result;
    }

    /**
     * Build map hash model.
     *
     * @param characters        the characters
     * @param startIdx          the start idx
     * @param openingClosingMap the opening closing map
     * @return hash model
     * @author Harsh Shah
     */
    public static HashModel buildMap(char[] characters, Integer startIdx,
                                     Map<Integer, Integer> openingClosingMap) {

        if (!openingClosingMap.containsKey(startIdx) || characters[startIdx] != OPENING_CURLY_BRACKET) {
            return null;
        }

        int i = startIdx;
        int endIdx = openingClosingMap.get(startIdx);

        HashModel result = new HashModel();

        // skip curly bracket
        i++;

        while (i < endIdx) {

            if (COMMA == characters[i]) {
                i++;
                continue;
            }

            StringBuilder keyBuilder = new StringBuilder();

            // skip quote
            i++;


            while (DOUBLE_QUOTE != characters[i]) {
                keyBuilder.append(characters[i++]);
            }

            // skip quote and colon
            i += 2;

            if (OPENING_SQUARE_BRACKET == characters[i]) {
                result.put(keyBuilder.toString(), buildArray(characters, i, openingClosingMap));
                if (openingClosingMap == null || !openingClosingMap.containsKey(i)) {
                    System.out.println(openingClosingMap);
                }
                i = openingClosingMap.get(i);

                // skip curly bracket
                i++;
            } else if (OPENING_CURLY_BRACKET == characters[i]) {
                result.put(keyBuilder.toString(), buildMap(characters, i, openingClosingMap));
                i = openingClosingMap.get(i);

                // skip curly bracket
                i++;
            } else {
                StringBuilder valueBuilder = new StringBuilder();

                // parse String value
                if (characters[i] == DOUBLE_QUOTE) {
                    i++;
                    while (!(characters[i] == DOUBLE_QUOTE &&
                            (characters[i + 1] == COMMA || characters[i + 1] == CLOSING_CURLY_BRACKET) &&
                            (i == 0 || characters[i - 1] != BACKSLASH))) {
                        valueBuilder.append(characters[i++]);
                    }
                } else {
                    while (!(characters[i] == COMMA || characters[i] == CLOSING_CURLY_BRACKET)) {
                        valueBuilder.append(characters[i++]);
                    }
                }

                i++;

                result.put(keyBuilder.toString(), valueBuilder.toString());
            }
        }

        return result;
    }

    /**
     * @param characters
     * @param startIdx
     * @param openingClosingMap
     * @return
     * @author Harsh Shah
     */
    private static List<Object> buildArray(char[] characters, int startIdx, Map<Integer, Integer> openingClosingMap) {


        if (!openingClosingMap.containsKey(startIdx) || characters[startIdx] != OPENING_SQUARE_BRACKET) {
            return null;
        }

        int i = startIdx;
        int endIdx = openingClosingMap.get(startIdx);

        List<Object> result = new ArrayList<>();

        // skip round bracket
        i++;

        while (i < endIdx) {
            Character character = characters[i];

            if (COMMA == character) {
                i++;
                continue;
            }

            if (OPENING_CURLY_BRACKET == character) {
                result.add(buildMap(characters, i, openingClosingMap));
                i = openingClosingMap.get(i);

                // skip curly bracket
                i++;
            } else {
                StringBuilder valueBuilder = new StringBuilder();

                // parse String value
                if (characters[i] == DOUBLE_QUOTE) {
                    i++;
                    while (!(characters[i] == DOUBLE_QUOTE &&
                            (characters[i + 1] == COMMA || characters[i + 1] == CLOSING_SQUARE_BRACKET) &&
                            (i == 0 || characters[i - 1] != BACKSLASH))) {
                        valueBuilder.append(characters[i++]);
                    }
                } else {
                    while (!(characters[i] == COMMA || characters[i] == CLOSING_SQUARE_BRACKET)) {
                        valueBuilder.append(characters[i++]);
                    }
                }

                result.add(valueBuilder.toString());

                // skip quote
                i++;
            }
        }


        return result;
    }

    /**
     * Parse hash model.
     *
     * @param jsonString the json string
     * @return hash model
     * @author Harsh Shah
     */
    public static HashModel parse(String jsonString) {
        Map<Integer, Integer> openingClosingMap = findOpeningClosingBrackets(jsonString);

        return buildMap(jsonString.toCharArray(), 0, openingClosingMap);

    }
}