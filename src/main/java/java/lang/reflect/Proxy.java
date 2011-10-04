package java.lang.reflect;


public class Proxy {
    
    private InvocationHandler handler;
    
    /**
     * Constructs a new Proxy instance.
     */
    protected Proxy(InvocationHandler theHandler) {
        handler = theHandler;
    }
    
    // TODO: Annotation
    //@Taint
    private static Object invoke(Proxy object, String methodSignature, Object[] args) throws Throwable {
        Method method = new Method(null, methodSignature);
        return object.handler.invoke(object, method, args);
    }
    
    /**
     * Returns an instance of a proxy class for the specified interfaces 
     * that dispatches method invocations to the specified invocation handler.
     */
    public static Object newProxyInstance(Object loader,
            Class[] interfaces, InvocationHandler handler) throws IllegalArgumentException {
        return new Proxy(handler);
    }
}
