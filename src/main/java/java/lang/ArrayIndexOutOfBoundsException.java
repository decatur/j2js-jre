/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.lang;

/**
 * Thrown to indicate that an array has been accessed with an illegal index.
 * The index is either negative or greater than or equal to the size of the array.
 */
public class ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException {

    public ArrayIndexOutOfBoundsException() {
        super();
    }
    
    public ArrayIndexOutOfBoundsException(int index) {
        super(index);
    }
    
}
