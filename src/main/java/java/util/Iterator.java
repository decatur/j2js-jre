/*
 * Copyright (c) 2006 j2js.com,
 *
 * All Rights Reserved. This work is distributed under the j2js Software License [1]
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 *
 * [1] http://www.j2js.com/license.txt
 */

package java.util;

/**
 * An iterator over a collection.
 * @author j2js.com
 */
public interface Iterator<E> {
    
    /**
     * Returns true if the iteration has more elements.
     */
    public boolean hasNext();

    /**
     * Returns the next element in the iteration.
     */
    public E next();

    /**
     * Removes from the underlying collection the last element returned by the iterator (optional operation).
     */
    public void remove();
     
}
