package com.scorpio4938.scribe.service.utils;

import java.util.Map;

public class MapKeyValueHandler {

//    /**
//     * Validates that the map and the given object (key or value) are not null.
//     *
//     * @param map The map to validate.
//     * @param obj The object (key or value) to validate.
//     * @throws IllegalArgumentException If the map or object is null.
//     */
//    private static <K, V> void validateInput(Map<K, V> map, Object obj, String objectName) {
//        if (map == null) {
//            throw new IllegalArgumentException("Map must not be null.");
//        }
//        if (obj == null) {
//            throw new IllegalArgumentException(objectName + " must not be null.");
//        }
//    }

    /**
     * Finds the value associated with a specific key in the map.
     *
     * @param map The map to search in.
     * @param key The key to find.
     * @return The value associated with the key.
     * @throws IllegalArgumentException If the map or key is null.
     * @throws KeyNotFoundException     If the key is not found in the map.
     */
    public static <K, V> V findValueByKey(Map<K, V> map, K key) {
        Validation.mapObjectInput(map, key, "Key");
        if (!map.containsKey(key)) {
            throw new KeyNotFoundException("Key '" + key + "' not found in the map.");
        }
        return map.get(key);
    }

    /**
     * Finds the key associated with a specific value in the map.
     *
     * @param map   The map to search in.
     * @param value The value to find.
     * @return The key associated with the value.
     * @throws IllegalArgumentException If the map or value is null.
     * @throws ValueNotFoundException   If the value is not found in the map.
     */
    public static <K, V> K findKeyByValue(Map<K, V> map, V value) {
        Validation.mapObjectInput(map, value, "Value");
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        throw new ValueNotFoundException("Value '" + value + "' not found in the map.");
    }

    /**
     * Checks if a specific key exists in the map.
     *
     * @param map The map to search in.
     * @param key The key to check.
     * @return True if the key exists, false otherwise.
     * @throws IllegalArgumentException If the map or key is null.
     */
    public static <K, V> boolean containsKey(Map<K, V> map, K key) {
        Validation.mapObjectInput(map, key, "Key");
        return map.containsKey(key);
    }

    /**
     * Checks if a specific value exists in the map.
     *
     * @param map   The map to search in.
     * @param value The value to check.
     * @return True if the value exists, false otherwise.
     * @throws IllegalArgumentException If the map or value is null.
     */
    public static <K, V> boolean containsValue(Map<K, V> map, V value) {
        Validation.mapObjectInput(map, value, "Value");
        return map.containsValue(value);
    }

    /**
     * Custom exception for when a key is not found in the map.
     */
    public static class KeyNotFoundException extends RuntimeException {
        public KeyNotFoundException(String message) {
            super(message);
        }
    }

    /**
     * Custom exception for when a value is not found in the map.
     */
    public static class ValueNotFoundException extends RuntimeException {
        public ValueNotFoundException(String message) {
            super(message);
        }
    }
}
