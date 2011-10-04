/*
 * Copyright (c) 2005 j2js.com,
 *
 * All Rights Reserved. This work is distributed under the j2js Software License [1]
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 *
 * [1] http://www.j2js.com/license.txt
 */

package java.lang;

/**
 * An IllegalAccessException is thrown when an application tries to reflectively create an instance
 * (other than an array), set or get a field, or invoke a method, but the currently executing method
 * does not have access to the definition of the specified class, field, method or constructor. 
 * 
 * @author j2js.com
 */
public class IllegalAccessException extends Exception {

    public IllegalAccessException() {
        super();
    }
    
}