package io.github.handsomecoder.utils.map;

import java.util.Map;

/**
 * The type Map utils.
 */
public class MapUtils {

    private MapUtils() {
    }

    /**
     * Of map.
     *
     * @param <K> the type parameter
     * @param <V> the type parameter
     * @param k1  the k 1
     * @param v1  the v 1
     * @param k2  the k 2
     * @param v2  the v 2
     * @return map map
     */
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        MapBuilder<K, V> map = new MapBuilder<>();
        map.add(k1, v1).add(k2, v2);
        return map.build();
    }

    /**
     * Of map.
     *
     * @param <K> the type parameter
     * @param <V> the type parameter
     * @param k1  the k 1
     * @param v1  the v 1
     * @param k2  the k 2
     * @param v2  the v 2
     * @param k3  the k 3
     * @param v3  the v 3
     * @param k4  the k 4
     * @param v4  the v 4
     * @return map map
     * @author Harsh Shah
     */
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        MapBuilder<K, V> map = new MapBuilder<>();
        map.add(k1, v1).add(k2, v2).add(k3, v3).add(k4, v4);
        return map.build();
    }
}
