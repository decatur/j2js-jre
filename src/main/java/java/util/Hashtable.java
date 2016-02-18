/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.util;

/**
 * This class implements a hashtable, which maps keys to values.
 * Any non-null object can be used as a key or as a value.
 * 
 * @deprecated
 */
public class Hashtable<K, V> extends HashMap<K, V> {
    
    public synchronized boolean contains(V value) {
        return containsValue(value);
    }
    
    public synchronized Enumeration elements() {
        return Collections.enumeration(values());
    }
    
    public synchronized Enumeration keys() {
        return Collections.enumeration(keySet());
    }
}
