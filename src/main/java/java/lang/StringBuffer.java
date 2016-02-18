/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.lang;

import javascript.ScriptHelper;


/**
 * A string buffer implements a mutable sequence of characters.
 * <br/>
 * <b>Note</b>: Please use {@link java.lang.StringBuilder} instead of this class!
 * 
 * Compared with the obvious sting concatination implementation,
 * this implementation runs 80 times faster on Opera 7.11, 40 times faster on MS-IExplorer 6.0,
 * and as fast on Firefox 1.0. 
 */
public class StringBuffer {
    
    public StringBuffer() {
        ScriptHelper.eval("this.buffer = new Array()");
    }
    
    public StringBuffer(String s) {
        this();
        append(s);
    }
    
    public StringBuffer(int length) {
        this();
    }
    
    public int length() {
        consolidate();
        return ScriptHelper.evalInt("this.buffer[0].length");
    }

    public void ensureCapacity(int minimumCapacity) {}

    /**
     * Sets the length of this string buffer.
     */
    public void setLength(int newLength) {
        int currentLength = length();
        if (newLength < currentLength) {
            delete(newLength, currentLength);
        } else if (newLength > currentLength) {
            for (int i=currentLength; i<newLength; i++) {
                append('\u0000');
            }
        }
    }

    public char charAt(int index) {
        consolidate();
        ScriptHelper.put("index", index);
        return ScriptHelper.evalChar("this.buffer[0].charCodeAt(index)");
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        throw new UnsupportedOperationException();
    }

    public void setCharAt(int index, char ch) {
        throw new UnsupportedOperationException();   
    }

    public StringBuffer append(Object obj) {
        return append(String.valueOf(obj));
    }

    public StringBuffer append(String s) {
        if (s == null) s = "null";
        ScriptHelper.put("s", s);
        ScriptHelper.eval("this.buffer.push(s)");
        return this;
    }

    public StringBuffer append(char[] str) {
        return append(str, 0, str.length);
    }

    public StringBuffer append(char[] str, int offset, int len) {
        for (int i=0; i<len; i++) {
            append(str[i + offset]);
        }
        return this;
    }

    public StringBuffer append(boolean b) {
        append(String.valueOf(b));
        return this;
    }
    
    public StringBuffer append(char c) {
        append(String.valueOf(c));
        return this;
    }

    public StringBuffer append(int i) {
        append(String.valueOf(i));
        return this;
    }

    public StringBuffer append(long l) {
        append(String.valueOf(l));
        return this;
    }

    public StringBuffer append(float f) {
        append(String.valueOf(f));
        return this;
    }

    public StringBuffer append(double d) {
        append(String.valueOf(d));
        return this;
    }

    public StringBuffer delete(int start, int end) {
        consolidate();
        ScriptHelper.put("start", start);
        ScriptHelper.put("end", end);
        ScriptHelper.eval("s = this.buffer[0]; this.buffer[0] = s.substring(0, start) + s.substring(end)");
        return this;
    }

    public StringBuffer deleteCharAt(int index) {
        return delete(index, index + 1);
    }

    public StringBuffer insert(int offset, Object obj) {
        return insert(offset, String.valueOf(obj));
    }

    public StringBuffer insert(int offset, String str) {
        consolidate();
        ScriptHelper.put("offset", offset);
        ScriptHelper.put("str", str);
        ScriptHelper.eval("var os = offset; s = this.buffer[0]; this.buffer[0] = s.substring(0, os) + str + s.substring(os)");
        return this;
    }

    public StringBuffer insert(int offset, char[] str) {
        return insert(offset, String.valueOf(str));
    }

    public StringBuffer insert(int offset, boolean b) {
        return insert(offset, String.valueOf(b));
    }

    public StringBuffer insert(int offset, char c) {
        return insert(offset, String.valueOf(c));
    }

    public java.lang.StringBuffer insert(int offset, int i) {
        return insert(offset, String.valueOf(i));
    }

    public java.lang.StringBuffer insert(int offset, long l) {
        return insert(offset, String.valueOf(l));
    }

    public java.lang.StringBuffer insert(int offset, float f) {
        return insert(offset, String.valueOf(f));
    }

    public java.lang.StringBuffer insert(int offset, double d) {
        return insert(offset, String.valueOf(d));
    }

    public java.lang.StringBuffer reverse() {
        consolidate();
        StringBuffer sb = new StringBuffer();
        int length = this.length();
        for (int i=length-1; i>=0; i--) {
            sb.append(charAt(i));
        }
        setLength(0);
        append(sb.toString());
        return this;
    }

    public String toString() {
        consolidate();
        return (String) ScriptHelper.eval("this.buffer[0]");
    }
    
    private void consolidate() {
        ScriptHelper.eval("var s = this.buffer.join(''); this.buffer = new Array(); this.buffer.push(s)");
    }
    
}
