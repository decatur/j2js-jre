/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.lang;

/**
 * RuntimeException is the superclass of those exceptions that can be thrown during the normal operation of the Java Virtual Machine.
 */
public class RuntimeException extends Throwable {
    
    public RuntimeException() {
        super();
    }
    
    public RuntimeException(String message) {
        super(message);
    }
    
    public RuntimeException(Throwable cause) {
        super(cause);
    }
}
