/*
 * Copyright (c) 2005 Wolfgang Kuehn
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
