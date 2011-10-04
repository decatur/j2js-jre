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
 * Thrown to indicate that an array has been accessed with an illegal index.
 * The index is either negative or greater than or equal to the size of the array.
 * 
 * @author j2js.com
 */
public class ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException {

    public ArrayIndexOutOfBoundsException() {
        super();
    }
    
    public ArrayIndexOutOfBoundsException(int index) {
        super(index);
    }
    
}
