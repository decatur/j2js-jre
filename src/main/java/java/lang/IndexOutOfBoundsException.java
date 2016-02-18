/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.lang;

/**
 * Thrown to indicate that an index of some sort is out of range.
 */
public class IndexOutOfBoundsException extends RuntimeException {

    public IndexOutOfBoundsException() {
        super();
    }
    
    public IndexOutOfBoundsException(int index) {
        super("Invalid index: " + index);
    }
    
}
