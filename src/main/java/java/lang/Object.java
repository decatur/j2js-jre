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

import javascript.ScriptHelper;

/**
 * Class Object is the root of the class hierarchy. Every class has Object as a superclass. All objects, including arrays, implement the methods of this class.
 */
public class Object {

    private static int hashCodeCount = 0;
    private int hashCode = Object.hashCodeCount++;
    
    public Object() {
    }
    
    public Object clone() {
        String className = (String) ScriptHelper.eval("this.clazz.name"); 
        
        // Special treatment for arrays, because for those we have no class to
        // overwrite the clone() method.
        if (className.startsWith("[")) {
            return ScriptHelper.eval("j2js.cloneArray(this)");
        }
        
        return null;
    }
    
    public boolean equals(Object obj) {
        return this == obj;
    }
    
    public Class getClass() {
        String className = (String) ScriptHelper.eval("this.clazz.name"); 
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int hashCode() {
        return hashCode;
    }

    public void notify() {}
   
    public void notifyAll() {}
    
    public String toString() {
        return getClass().toString() + "@" + hashCode;
    }
    
    public void wait() {} 
    public void wait(long timeout) {} 
    public void wait(long timeout, int nanos) {} 

}
