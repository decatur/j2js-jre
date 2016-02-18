/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.lang;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

import javascript.JSObject;
import javascript.ScriptHelper;

/**
 * Instances of the class Class represent classes and interfaces in a running Java application.
 */
public final class Class<T> {
    
    private class AnnotationInvocationHandler implements InvocationHandler {
        
        private JSObject object;
        
        AnnotationInvocationHandler(JSObject theObject) {
            object = theObject;
        }
        
        public Object invoke(Object proxy, Method method, Object[] args) {
            // TODO: Annotation
            String name = method.getName();
            if (name.equals("toString")) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("@" + object.get("$signature"));
                return buffer.toString();
            }
            return object.get(method.getName());
            //return "@" + object.get("signature") + "(" + method.getName() + "=13)";
        }
    }

    private static HashMap<String, Class> classesByName = new HashMap<String, Class>();
    private Object nativeClass;
    
    private Class(Object theNativeClass) {
        nativeClass = theNativeClass;
    }

    //Converts the object to a string. The string representation is the string "class" or "interface", followed by a space, and then by the fully qualified name of the class in the format returned by getName. If this Class object represents a primitive type, this method returns the name of the primitive type. If this Class object represents void this method returns "void". 
    public String toString() {
        return "class " + getName();
    }

    public static Class<?> forName(String className) throws ClassNotFoundException {
        Class clazz = classesByName.get(className);
        if (clazz != null) return clazz;
        
        ScriptHelper.put("className", className);
        Object nativeClass = ScriptHelper.eval("j2js.forName(className)");
        
        if (nativeClass == null) {
            throw new ClassNotFoundException(className);
        }
        
        clazz = new Class(nativeClass);
        classesByName.put(className, clazz);
        return clazz;
    }
    
    /**
     * Returns the Class representing the component type of an array.
     * If this class does not represent an array class this method returns null. 
     */
    public Class<?> getComponentType() {
        throw new UnsupportedOperationException();
    }

    public Object newInstance() throws InstantiationException, IllegalAccessException {
        // Create a new instance.
        ScriptHelper.eval("var o = this.nativeClass.newInstance()");
        // Initialize it.
        ScriptHelper.eval("j2js.invoke(o, '<init>()void', [])");
        return ScriptHelper.eval("o");
    }

    /**
     * Determines if the specified Object is assignment-compatible with the object represented by this Class.
     */
    public boolean isInstance(Object obj) {
        Class cls = obj.getClass();
        do {
            if (cls.getName().equals(getName())) {
                return true;
            }
            if (cls.getName().equals("java.lang.Object")) {
                return false;
            }
            cls = cls.getSuperclass();
        } while (true);
    }

    /**
     * Determines if the class or interface represented by this Class object is either the same as, or is a
     * superclass or superinterface of, the class or interface represented by the specified Class parameter.
     */
    public boolean isAssignableFrom(Class<?> otherClass) {
        if (otherClass == null) throw new NullPointerException();
        ScriptHelper.put("otherClass", otherClass);
        return ScriptHelper.evalBoolean("this.nativeClass.isAssignable(otherClass.nativeClass)");
    }

    public boolean isInterface() {
        throw new UnsupportedOperationException();
    }

    public boolean isArray() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the class loader for the class.
     */
    public Object getClassLoader() {
        return null;
    }

    public String getName() {
        return (String) ScriptHelper.eval("this.nativeClass.name");
    }
    
    /**
     * Returns the Class representing the superclass of the entity (class, interface, primitive type or void)
     * represented by this Class.
     */
    public Class<? super T> getSuperclass() {
        if (ScriptHelper.evalBoolean("this.nativeClass.superClass == null")) return null;
        
        String superClassName = (String) ScriptHelper.eval("this.nativeClass.superClass.name");
        try {
            return (Class<? super T>) Class.forName(superClassName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
     
    /**
     * Returns an array of Method objects reflecting all the methods declared by the class or interface represented
     * by this Class object. 
     */
    public Method[] getDeclaredMethods() {
        Method[] methods = new Method[0];
        String[] signatures = new String[0];
        ScriptHelper.put("signatures", signatures);
        ScriptHelper.eval("for (var e in this.nativeClass.constr.prototype) { signatures.push(e); }");
        for (int i=0, j=0; i<signatures.length; i++) {
            String signature = signatures[i];
            // Do not include constructors, class initializers or member variables.
            if (signature.startsWith("<init>") || signature.startsWith("<clinit>") || signature.indexOf("(")==-1) continue;
            methods[j] = new Method(this, signatures[i]);
            j++;
        }
        return methods;
    }
    
    /**
     * Returns all annotations that are directly present on this element.
     */
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] annotations = new Annotation[0];
        Object[] maps = (Object[]) ScriptHelper.eval("this.nativeClass.annotations");
        if (maps == null) return annotations;
        
        int i = 0;
        for (Object map : maps) {
//            Class c = null;
//            try {
//                c = Class.forName(map.get("signature"));
//            }
            InvocationHandler handler = new AnnotationInvocationHandler(new JSObject(map));
            Annotation annotation = (Annotation) Proxy.newProxyInstance(null, new Class[] { null }, handler);
            annotations[i++] = annotation;
        }
        return annotations;
    }
    
    /**
     * Returns the assertion status that would be assigned to this class if it were to be initialized at the time this method is invoked.
     * @return the desired assertion status of the class.
     */
    public boolean desiredAssertionStatus() {
        return false;
    }

}
