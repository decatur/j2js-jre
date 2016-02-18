/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.util;

/**
 * An object that implements the Enumeration interface generates a series of elements, one at a time.
 * Successive calls to the nextElement method return successive elements of the series.
 */
public interface Enumeration<E> {

    /* (non-Javadoc)
     * @see java.util.Enumeration#hasMoreElements()
     */
    public boolean hasMoreElements();

    /* (non-Javadoc)
     * @see java.util.Enumeration#nextElement()
     */
    public E nextElement();

}
