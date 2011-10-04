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
 * Every Java application has a single instance of class Runtime that allows the
 * application to interface with the environment in which the application is running.
 * 
 * @author j2js.com
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
