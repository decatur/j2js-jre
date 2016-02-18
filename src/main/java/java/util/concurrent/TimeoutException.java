/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.util.concurrent;

/**
 * RuntimeException is the superclass of those exceptions that can be thrown during the normal operation of the Java Virtual Machine.
 */
public class TimeoutException extends Throwable {
    
    public TimeoutException() {
        super();
    }
    
    public TimeoutException(String message) {
        super(message);
    }
}
