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

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

import javascript.ScriptHelper;

/**
 * The Throwable class is the superclass of all errors and exceptions in the Java language.
 */
public class Throwable {

    private String message;
    private Throwable cause;
    private String stackTrace;
    
    public Throwable() {
    }

    public Throwable(String newMessage) {
        message = newMessage;
    }

    public Throwable(Throwable theCause) {
        cause = theCause;
    }
    
    public String getMessage() {
        return message;
    }

    public String toString() {
        String s = this.getClass().getName();
        if (message != null) {
            s += ": " + message;
        }
        return s;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }
    
    public void printStackTrace(PrintStream stream) {
        printStackTrace(new PrintWriter(new OutputStreamWriter(stream)));
    }
    
    /**
     * Prints this throwable and its backtrace to the specified print writer.
     */
    public void printStackTrace(PrintWriter printWriter) {
        
        printWriter.print(toString());
        printWriter.println(stackTrace);
        
        if (cause != null) {
            printWriter.println("Caused by:");
            cause.printStackTrace(printWriter);
        }
    }

    /**
     * Returns the cause of this throwable or null if the cause is nonexistent or unknown.
     */
    public Throwable getCause() {
        return cause;
    }
    
    /**
     * Fills in the execution stack trace.
     */
    public Throwable fillInStackTrace() {
        stackTrace = (String) ScriptHelper.eval("stackTrace.toString()");
        return this;
    }

}
