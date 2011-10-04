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
