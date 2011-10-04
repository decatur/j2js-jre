package java.lang.reflect;

import java.lang.annotation.Annotation;

import javascript.ScriptHelper;

/**
 * A Method provides information about, and access to, a single method on a class or interface.
 * @author j2js.com
 */
public final class Method {
    
    private String signature;
    private Class cls;
    
    /**
    * <b>IMPORTANT</b>: This constructor is not part of the public API.
    */
    public Method(Class newCls, String theSignature) {
        signature = theSignature;
        cls = newCls;
    }
    
    /**
     * Returns the name of the method represented by this Method object, as a String.
     */
    public String getName() {
        int index = signature.indexOf("(");
        //if (index == -1) return signature;
        return signature.substring(0, index);
    }
    
    /**
     * Returns an array of Class objects that represent the formal parameter types,
     * in declaration order, of the method represented by this Method object.
     */
    public Class[] getParameterTypes() {
        int index = signature.indexOf("(");
        String s = signature.substring(index+1, signature.lastIndexOf(')'));
        String[] typeNames = s.split(",");
        Class[] types = new Class[typeNames.length];
        for (int i=0; i<typeNames.length; i++) {
            try {
                types[i] = Class.forName(typeNames[i]);
            } catch(ClassNotFoundException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return types;
    }

    /**
     * Invokes the underlying method represented by this Method object,
     * on the specified object with the specified parameters.
     */
    public Object invoke(Object obj, Object... args) {
        if (args != null) {
            throw new UnsupportedOperationException("Invokation of methods with parameters are not yet supported");
        }
        ScriptHelper.put("obj", obj);
        ScriptHelper.put("args", args);
        return ScriptHelper.eval("this.cls.nativeClass.invoke(obj, this.signature, [args])");
    }
    
    public boolean isAnnotationPresent(Class<? extends Annotation> annotation) {
        throw new UnsupportedOperationException();
    }
    
    public String toString() {
        return signature;
    }
}
