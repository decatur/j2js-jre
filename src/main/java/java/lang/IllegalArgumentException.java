/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.lang;

/**
 * Thrown to indicate that a method has been passed an illegal or inappropriate argument.
 */
public class IllegalArgumentException extends RuntimeException {
    
    public IllegalArgumentException() {
        super();
    }
    
    public IllegalArgumentException(String message) {
        super(message);
    }
    
    public IllegalArgumentException(Throwable cause) {
        super(cause);
    }
}
