package io.github.handsomecoder.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The type File utils.
 *
 * @author Harsh Shah
 */
public class FileUtils {

    private FileUtils() {
    }

    /**
     * Create directory int.
     *
     * @param path the path
     * @return int
     * @author Harsh Shah
     */
    public static int createDirectory(Path path) {

        if (Files.notExists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * Create directory int.
     *
     * @param start the start
     * @param tails the tails
     * @return int
     */
    public static int createDirectory(String start, String... tails) {

        Path path = Path.of(start, tails);

        return createDirectory(path);
    }


    /**
     * Create file int.
     *
     * @param start the start
     * @param tails the tails
     * @return int
     * @author Harsh Shah
     */
    public static int createFile(String start, String... tails) {

        Path path = Path.of(start, tails);

        if (path == null) {
            return -1;
        }

        return createFile(path);
    }

    /**
     * Create file int.
     *
     * @param path the path
     * @return int
     * @author Harsh Shah
     */
    public static int createFile(Path path) {
        if (Files.notExists(path)) {
            try {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            } catch (IOException e) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * Is exists boolean.
     *
     * @param path the path
     * @return boolean
     * @author Harsh Shah
     */
    public static boolean isExists(Path path) {
        if (path == null) {
            return false;
        }

        return Files.exists(path);
    }

    /**
     * Is not exists boolean.
     *
     * @param path the path
     * @return boolean
     * @author Harsh Shah
     */
    public static boolean isNotExists(Path path) {
        return !isExists(path);
    }

    /**
     * Read list.
     *
     * @param start the start
     * @param more  the more
     * @return list
     * @author Harsh Shah
     */
    public static List<String> read(String start, String... more) {
        try {

            Path path = Path.of(start, more);

            if (isNotExists(path)) {
                return Collections.emptyList();
            }
            return Files.readAllLines(path);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }


    /**
     * Write int.
     *
     * @param line          the line
     * @param startLocation the start location
     * @param location      the location
     * @return int
     * @author Harsh Shah
     */
    public static int write(String line, String startLocation, String... location) {
        return write(Arrays.asList(line), startLocation, location);
    }


    /**
     * Write int.
     *
     * @param lines          the lines
     * @param startDirectory the start directory
     * @param location       the location
     * @return int
     * @author Harsh Shah
     */
    public static int write(List<String> lines, String startDirectory, String... location) {

        Path path = Path.of(startDirectory, location);

        path = path.toAbsolutePath();

        if (Files.notExists(path)) {
            try {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
                return -1;
            }
        }

        try {
            Files.write(path, lines, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

        return 0;
    }
}
