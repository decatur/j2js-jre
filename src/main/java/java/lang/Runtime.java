/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.lang;

import javascript.ScriptHelper;

/**
 * Every Java application has a single instance of class Runtime that allows the
 * application to interface with the environment in which the application is running.
 */
public class Runtime {
    
    /**
     * Returns the runtime object associated with the current Java application.
     */
    public static Runtime getRuntime() {
        return new Runtime();
    }
    
    /**
     * Enables/Disables tracing of method calls.
     */
    public void traceMethodCalls(boolean on) {
        ScriptHelper.put("tracing", on);
        ScriptHelper.eval("j2js.tracing = tracing");
    }

}
