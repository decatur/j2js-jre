package java.util;

/**
 * An object that maps keys to values.
 * A map cannot contain duplicate keys; each key can map to at most one value.
 */
public interface Map<K, V> {

    /**
     * Removes all mappings from this map.
     */
    public void clear();

    /**
     * Returns true if this map contains a mapping for the specified key.
     */
    public boolean containsKey(Object key);

    /**
     * Returns true if this map maps one or more keys to the specified value.
     */
    public boolean containsValue(Object value);

    /**
     * Returns the value to which the specified key is mapped in this identity hash map,
     * or null if the map contains no mapping for this key.
     */
    public V get(K key);

    /**
     * Returns true if this map contains no key-value mappings.
     */
    public boolean isEmpty();

    /**
     * Returns a set view of the keys contained in this map.
     */
    public Set<K> keySet();

    /**
     * Associates the specified value with the specified key in this map.
     */
    public V put(K key, V value);

    /**
     * Removes the mapping for this key from this map if present.
     */
    public V remove(Object key);

    /**
     * Returns the number of key-value mappings in this map.
     */
    public int size();

    /**
     * Returns a collection view of the values contained in this map.
     */
    public Collection<V> values();

}