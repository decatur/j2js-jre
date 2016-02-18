/*
 * Copyright (c) 2006 Wolfgang Kuehn
 */

package java.util;

/**
 * An iterator over a collection.
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
