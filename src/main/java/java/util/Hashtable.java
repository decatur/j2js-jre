/*
 * Copyright (c) 2005 j2js.com,
 *
 * All Rights Reserved. This work is distributed under the j2js Software License [1]
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 *
 * [1] http://www.j2js.com/license.txt
 */

package java.util;

/**
 * This class implements a hashtable, which maps keys to values.
 * Any non-null object can be used as a key or as a value.
 * 
 * @deprecated
 * @author j2js.com
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
