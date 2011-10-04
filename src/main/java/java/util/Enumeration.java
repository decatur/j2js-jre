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
 * An object that implements the Enumeration interface generates a series of elements, one at a time.
 * Successive calls to the nextElement method return successive elements of the series.
 * 
 * @author j2js.com
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
