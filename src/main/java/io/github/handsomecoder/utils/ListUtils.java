package io.github.handsomecoder.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type List utils.
 *
 * @author Harsh Shah
 */
public class ListUtils {

    /**
     * Project list.
     *
     * @param projection the projection
     * @param values     the values
     * @return list list
     * @author Harsh Shah
     */
    public static List<Object> project(List<Integer> projection, List<Object> values) {
        List<Object> result = new ArrayList<>();
        for (Integer project : projection) {
            result.add(values.get(project));
        }

        return result;
    }

    /**
     * Difference list.
     *
     * @param source the source
     * @param target the target
     * @return list list
     * @author Harsh Shah
     */
    public static List<Object> difference(List<Object> source, List<Object> target) {
        HashSet<Object> targetSet = new HashSet<>(target);
        return source.stream().filter(itr -> !targetSet.contains(itr)).collect(Collectors.toList());
    }

    /**
     * Common list.
     *
     * @param list1 the list 1
     * @param list2 the list 2
     * @return list list
     * @author Harsh Shah
     */
    public static List<Object> common(List<Object> list1, List<Object> list2) {
        HashSet<Object> list2Set = new HashSet<>(list2);
        return list1.stream().filter(itr -> list2Set.contains(itr)).collect(Collectors.toList());
    }
}
