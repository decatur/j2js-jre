/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.lang;

/**
 * Thrown by String methods to indicate that an index is either negative or greater than the size of the string.
 * For some methods such as the charAt method, this exception also is thrown when the index is equal to the
 * size of the string. 
 */
public class StringIndexOutOfBoundsException extends IndexOutOfBoundsException {

    public StringIndexOutOfBoundsException() {
        super();
    }
    
    public StringIndexOutOfBoundsException(int index) {
        super(index);
    }
    
}
