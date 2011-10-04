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
 * Thrown to indicate that the requested operation is not supported.
 * 
 * @author j2js.com
 */
public class UnsupportedOperationException extends RuntimeException {
    
    public UnsupportedOperationException() {
        super("Operation (not yet) supported");
    }
    
    public UnsupportedOperationException(String message) {
        super(message);
    }
}
