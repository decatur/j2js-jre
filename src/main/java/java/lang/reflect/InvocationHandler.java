package java.lang.reflect;

/**
 * InvocationHandler is the interface implemented by the invocation handler of a proxy instance.
 */
public interface InvocationHandler {
    
    /**
     * Processes a method invocation on a proxy instance and returns the result.
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
