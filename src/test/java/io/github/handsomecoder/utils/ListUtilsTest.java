package io.github.handsomecoder.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static io.github.handsomecoder.utils.ListUtils.project;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListUtilsTest {

    public static Stream<Arguments> testProjectDatasource() {
        return Stream.of(
                Arguments.of(Arrays.asList("1", "2"), Arrays.asList("1", "2", "3", "4"), Arrays.asList(0, 1)),
                Arguments.of(emptyList(), Arrays.asList("1", "2", "3", "4"), emptyList()),
                Arguments.of(Arrays.asList("1"), Arrays.asList("1", "2", "3", "4"), Arrays.asList(0, 5)),
                Arguments.of(emptyList(), emptyList(), Arrays.asList(0, 5))
        );
    }


    @ParameterizedTest(name = "{index}: testProject() = {1}")
    @MethodSource("testProjectDatasource")
    void testProject(List<Object> expected, List<Object> list, List<Integer> projection) {
        assertArrayEquals(expected.toArray(), project(projection, list).toArray());
    }

}