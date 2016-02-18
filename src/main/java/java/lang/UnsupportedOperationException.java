/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.lang;

/**
 * Thrown to indicate that the requested operation is not supported.
 */
public class UnsupportedOperationException extends RuntimeException {
    
    public UnsupportedOperationException() {
        super("Operation (not yet) supported");
    }
    
    public UnsupportedOperationException(String message) {
        super(message);
    }
}
