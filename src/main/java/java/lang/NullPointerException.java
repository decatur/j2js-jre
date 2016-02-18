/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.lang;

/**
 * Thrown when an application attempts to use null in a case where an object is required.
 */
public class NullPointerException extends RuntimeException {

    public NullPointerException() {
        super();
    }

    public NullPointerException(String message) {
        super(message);
    }
}
