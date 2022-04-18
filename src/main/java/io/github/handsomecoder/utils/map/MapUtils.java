package io.github.handsomecoder.utils.map;

import java.util.Map;

public class MapUtils {

    private MapUtils() {
    }

    /**
     * @param k1
     * @param v1
     * @param k2
     * @param v2
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        MapBuilder<K, V> map = new MapBuilder<>();
        map.add(k1, v1).add(k2, v2);
        return map.build();
    }

    /**
     * @param k1
     * @param v1
     * @param k2
     * @param v2
     * @param k3
     * @param v3
     * @param k4
     * @param v4
     * @param <K>
     * @param <V>
     * @return
     * @author Harsh Shah
     */
    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        MapBuilder<K, V> map = new MapBuilder<>();
        map.add(k1, v1).add(k2, v2).add(k3, v3).add(k4, v4);
        return map.build();
    }
}
