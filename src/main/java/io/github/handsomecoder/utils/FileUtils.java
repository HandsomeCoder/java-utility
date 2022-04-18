package io.github.handsomecoder.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Harsh Shah
 */
public class FileUtils {

    private FileUtils() {
    }

    /**
     * @param path
     * @return
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
     * @param start
     * @param tails
     * @return
     */
    public static int createDirectory(String start, String... tails) {

        Path path = Path.of(start, tails);

        if (path == null) {
            return -1;
        }

        return createDirectory(path);
    }


    /**
     * @param start
     * @param tails
     * @return
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
     * @param path
     * @return
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
     * @param path
     * @return
     * @author Harsh Shah
     */
    public static boolean isExists(Path path) {
        if (path == null) {
            return false;
        }

        return Files.exists(path);
    }

    /**
     * @param path
     * @return
     * @author Harsh Shah
     */
    public static boolean isNotExists(Path path) {
        return !isExists(path);
    }

    /**
     * @param start
     * @param more
     * @return
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
     * @param line
     * @param startLocation
     * @param location
     * @return
     * @author Harsh Shah
     */
    public static int write(String line, String startLocation, String... location) {
        return write(Arrays.asList(line), startLocation, location);
    }


    /**
     * @param lines
     * @param startDirectory
     * @param location
     * @return
     * @author Harsh Shah
     */
    public static int write(List<String> lines, String startDirectory, String... location) {

        Path path = Path.of(startDirectory, location);

        if (path == null) {
            return -1;
        }


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
