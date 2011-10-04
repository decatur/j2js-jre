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
