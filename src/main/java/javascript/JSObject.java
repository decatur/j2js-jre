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
 * Represents a native JavaScript object.
 * 
 * @author j2js.com
 */
public class JSObject {
    
    public static Object getProperty(Object obj, String propertyName) {
        System.scriptEngine.put("obj", obj);
        System.scriptEngine.put("propertyName", propertyName);
        return System.scriptEngine.eval("obj[propertyName]");
    }
    
    public static boolean containsKey(Object obj, String propertyName) {
        System.scriptEngine.put("obj", obj);
        System.scriptEngine.put("propertyName", propertyName);
        // Warning: Cannot use (obj[propertyName] != undefined) because
        // (null == undefined) evaluates to true.
        return ScriptHelper.evalBoolean("typeof(obj[propertyName]) != 'undefined'");
    }
    
    public JSObject() {
        System.scriptEngine.eval("this.obj = new Object()");
    }
    
    public JSObject(Object obj) {
        System.scriptEngine.put("obj", obj);
        System.scriptEngine.eval("this.obj = obj");
    }
    
    public JSObject(String javascriptRef) {
        System.scriptEngine.put("javascriptRef", javascriptRef);
        System.scriptEngine.eval("this.obj = eval(javascriptRef)");
    }
    
    public boolean containsKey(String propertyName) {
        return containsKey(System.scriptEngine.eval("this.obj"), propertyName);
    }
    
    public Object get(String key) {
        System.scriptEngine.put("key", key);
        if (containsKey(System.scriptEngine.eval("this.obj"), key)) {
            return System.scriptEngine.eval("this.obj[key]");
        }
        return null;
    }
    
    public void put(String key, Object value) {
        System.scriptEngine.put("key", key);
        System.scriptEngine.put("value", value);
        System.scriptEngine.eval("this.obj[key] = value");
    }
    
    public void remove(String key) {
        System.scriptEngine.put("key", key);
        System.scriptEngine.eval("delete this.obj[key]");
    }
    
    public String[] keys() {
        System.scriptEngine.eval("var keys = new Array(); for (var e in this.obj) keys.push(e)");
        return (String[]) System.scriptEngine.eval("keys");
    }
}
