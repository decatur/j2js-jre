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
 * Thrown when an application attempts to use null in a case where an object is required.
 * 
 * @author j2js.com
 */
public class NullPointerException extends RuntimeException {

    public NullPointerException() {
        super();
    }

    public NullPointerException(String message) {
        super(message);
    }
}
