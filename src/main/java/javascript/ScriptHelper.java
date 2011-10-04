/*
 * Copyright (c) 2005 j2js.com,
 *
 * All Rights Reserved. This work is distributed under the j2js Software License [1]
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 *
 * [1] http://www.j2js.com/license.txt
 */

package javascript;

/**
 * Helper class for {@link javax.script.ScriptEngine}. It overloads the put and eval method
 * to make passing primitive types to and from JavaScript easy.
 * 
 * @author j2js.com
 */
public final class ScriptHelper {
    
    /**
     * Sets a key/value pair of <code>Object</type> type.
     */
    public static native void put(String s, Object value);
    
    /**
     * Sets a key/value pair of <code>boolean</code> type.
     */
    public static native void put(String s, boolean value);
    
    /**
     * Sets a key/value pair of <code>primitive</code> type,
     * except of type <code>boolean</code>.
     */
    public static native void put(String s, double value);
    
    //public static native Object get(String s);

    /**
     * Executes the specified script.
     * <b>Important</b>: In the current version the script must be a string literal.
     * 
     * @return the object returned by the JavaScript code
     */
    public static native Object eval(String script);
    
    /**
     * Same as {@link ScriptHelper#eval(String)}, but returns an int.
     */
    public static native int evalInt(String jsCode);
    
    /**
     * Same as {@link ScriptHelper#eval(String)}, but returns a long.
     */
    public static native long evalLong(String jsCode);
    
    /**
     * Same as {@link ScriptHelper#eval(String)}, but returns float.
     */
    public static native float evalFloat(String jsCode);
    
    /**
     * Same as {@link ScriptHelper#eval(String)}, but returns a double.
     */
    public static native double evalDouble(String jsCode);
    
    /**
     * Same as {@link ScriptHelper#eval(String)}, but returns a char.
     */
    public static native char evalChar(String jsCode);
    
    /**
     * Same as {@link ScriptHelper#eval(String)}, but returns a boolean.
     */
    public static native boolean evalBoolean(String jsCode);
}
