package io.github.handsomecoder.utils.map;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Map builder.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class MapBuilder<K, V> {

    private Map<K, V> map;

    /**
     * Instantiates a new Map builder.
     */
    public MapBuilder() {
        map = new HashMap<>();
    }


    /**
     * Add map builder.
     *
     * @param key   the key
     * @param value the value
     * @return the map builder
     */
    public MapBuilder<K, V> add(K key, V value) {
        map.put(key, value);
        return this;
    }

    /**
     * Build map.
     *
     * @return the map
     */
    public Map<K, V> build() {
        return map;
    }
}
