package java.util;

import javascript.JSObject;

/**
 * Hash table based implementation of the Map interface.
 */
public class HashMap<K, V> implements Map<K, V> {
    JSObject nativeMap;
    
    /**
     * This constructor is not part of the public API. Do not use it!
     */
    public HashMap(Object theNativeObject) {
        nativeMap = new JSObject(theNativeObject);
    }
    
    /**
     * Constructs an empty HashMap.
     */
    public HashMap() {
        nativeMap = new JSObject();
    }
    
    /**
     * Removes all mappings from this map.
     */
    public void clear() {
        nativeMap = new JSObject();
    }
    
    /**
     * Returns true if this map contains a mapping for the specified key.
     */
    public boolean containsKey(Object key) {
        return nativeMap.containsKey((String) key);
    }
    
    /**
     * Returns true if this map maps one or more keys to the specified value.
     */
    public boolean containsValue(Object value) {
        String[] keys = nativeMap.keys();
        for (String key : keys) {
            if (nativeMap.get(key) == value) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns the value to which the specified key is mapped in this identity hash map,
     * or null if the map contains no mapping for this key.
     */
    public V get(K key) {
        return (V) nativeMap.get((String) key);
    }
    
    /**
     * Returns true if this map contains no key-value mappings.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
     * Returns a set view of the keys contained in this map.
     */
    public HashSet<K> keySet() {
        HashSet<K> set = new HashSet<K>();
        K[] keys = (K[]) nativeMap.keys();
        for (int i=0; i<keys.length; i++) {
            set.add(keys[i]);
        }
        return set;
    }
    
    /**
     * Associates the specified value with the specified key in this map.
     */
    public V put(K key, V value) {
        V oldValue = (V) nativeMap.get((String) key);
        if (oldValue == null) oldValue = null;
        nativeMap.put((String) key, value);
        return oldValue;
    }
    
    /**
     * Removes the mapping for this key from this map if present.
     */
    public V remove(Object key) {
        V oldValue = (V) nativeMap.get((String) key);
        if (oldValue == null) oldValue = null;
        nativeMap.remove((String) key);
        return oldValue;
    }
    
    /**
     * Returns the number of key-value mappings in this map.
     */
    public int size() {
        return nativeMap.keys().length;
    }
    
    /**
     * Returns a string representation of this map.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        String[] keys = nativeMap.keys();
        for (int i=0; i<keys.length; i++) {
            String key = keys[i];
            if (i>0) sb.append(", ");
            Object value = nativeMap.get(key);
            sb.append(key.toString());
            sb.append("=");
            sb.append(value==null?"null":value.toString());
        }
        sb.append("}");
        return sb.toString();
    }
    
    /**
     * Returns a collection view of the values contained in this map.
     */
    public Collection<V> values() {
        List<V> list = new ArrayList<V>();
        String[] keys = nativeMap.keys();
        for (int i=0; i<keys.length; i++) {
            list.add((V) nativeMap.get(keys[i]));
        }
        return list;
    }
}
