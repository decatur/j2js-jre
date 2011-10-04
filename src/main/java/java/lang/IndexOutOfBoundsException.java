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
 * Thrown to indicate that an index of some sort is out of range.
 * 
 * @author j2js.com
 */
public class IndexOutOfBoundsException extends RuntimeException {

    public IndexOutOfBoundsException() {
        super();
    }
    
    public IndexOutOfBoundsException(int index) {
        super("Invalid index: " + index);
    }
    
}
