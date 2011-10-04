/*
 * Copyright (c) 2005 j2js.com,
 *
 * All Rights Reserved. This work is distributed under the j2js Software License [1]
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 *
 * [1] http://www.j2js.com/license.txt
 */

package java.io;

/**
 * Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
 * 
 * @author j2js.com
 */
public class IOException extends Exception {

    /**
     * Constructs an IOException with null  as its error detail message.
     */
    public IOException() {}

    /**
     * Constructs an IOException with the specified detail message.
     */
    public IOException(String s) {}
}
