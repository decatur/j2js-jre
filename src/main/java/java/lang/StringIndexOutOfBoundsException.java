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
 * Thrown by String methods to indicate that an index is either negative or greater than the size of the string.
 * For some methods such as the charAt method, this exception also is thrown when the index is equal to the
 * size of the string. 
 * 
 * @author j2js.com
 */
public class StringIndexOutOfBoundsException extends IndexOutOfBoundsException {

    public StringIndexOutOfBoundsException() {
        super();
    }
    
    public StringIndexOutOfBoundsException(int index) {
        super(index);
    }
    
}
