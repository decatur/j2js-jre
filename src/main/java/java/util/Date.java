package java.util;

import javascript.ScriptHelper;

public class Date {

    private Object nativeDate;
    
    public Date() {
        ScriptHelper.eval("this.nativeDate = new Date()");
    }

    public Date(long millis) {
        ScriptHelper.put("millis", millis);
        ScriptHelper.eval("this.nativeDate = new Date(millis)");
    }

    public long getTime() {
        return ScriptHelper.evalLong("this.nativeDate.getTime()");
    }

    public void setTime(long millis) {
        ScriptHelper.put("millis", millis);
        ScriptHelper.eval("this.nativeDate.setTime(millis)");
    }

    public boolean equals(Object obj) {
        Date other = (Date) obj;
        return getTime() == other.getTime();
    }

    public int hashCode() {
        long time = getTime();
        return (int) (time^(time >>> 32));
    }

    public String toString() {
        return (String) ScriptHelper.eval("this.nativeDate.toGMTString()");   
    }
}
