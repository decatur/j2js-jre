/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.lang;

/**
 * An IllegalAccessException is thrown when an application tries to reflectively create an instance
 * (other than an array), set or get a field, or invoke a method, but the currently executing method
 * does not have access to the definition of the specified class, field, method or constructor. 
 */
public class IllegalAccessException extends Exception {

    public IllegalAccessException() {
        super();
    }
    
}
