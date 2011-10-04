package java.lang;

import javascript.ScriptHelper;

/**
 * This class provides an API compatible with <code>StringBuffer</code>.
 * Please use this class instead of {@link java.lang.StringBuffer}.
 * 
 * @author j2js.com
 */
public class StringBuilder {
    
    public StringBuilder() {
        ScriptHelper.eval("this.buffer = new Array()");
    }
    
    public StringBuilder(String s) {
        this();
        append(s);
    }
    
    public StringBuilder(int length) {
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

    public StringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    public StringBuilder append(String s) {
        if (s == null) s = "null";
        ScriptHelper.put("s", s);
        ScriptHelper.eval("this.buffer.push(s)");
        return this;
    }

    public StringBuilder append(char[] str) {
        return append(str, 0, str.length);
    }

    public StringBuilder append(char[] str, int offset, int len) {
        for (int i=0; i<len; i++) {
            append(str[i + offset]);
        }
        return this;
    }

    public StringBuilder append(boolean b) {
        append(String.valueOf(b));
        return this;
    }
    
    public StringBuilder append(char c) {
        append(String.valueOf(c));
        return this;
    }

    public StringBuilder append(int i) {
        append(String.valueOf(i));
        return this;
    }

    public StringBuilder append(long l) {
        append(String.valueOf(l));
        return this;
    }

    public StringBuilder append(float f) {
        append(String.valueOf(f));
        return this;
    }

    public StringBuilder append(double d) {
        append(String.valueOf(d));
        return this;
    }

    public StringBuilder delete(int start, int end) {
        consolidate();
        ScriptHelper.put("start", start);
        ScriptHelper.put("end", end);
        ScriptHelper.eval("s = this.buffer[0]; this.buffer[0] = s.substring(0, start) + s.substring(end)");
        return this;
    }

    public StringBuilder deleteCharAt(int index) {
        return delete(index, index + 1);
    }

    public StringBuilder insert(int offset, Object obj) {
        return insert(offset, String.valueOf(obj));
    }

    public StringBuilder insert(int offset, String str) {
        consolidate();
        ScriptHelper.put("offset", offset);
        ScriptHelper.put("str", str);
        ScriptHelper.eval("var os = offset; s = this.buffer[0]; this.buffer[0] = s.substring(0, os) + str + s.substring(os)");
        return this;
    }

    public StringBuilder insert(int offset, char[] str) {
        return insert(offset, String.valueOf(str));
    }

    public StringBuilder insert(int offset, boolean b) {
        return insert(offset, String.valueOf(b));
    }

    public StringBuilder insert(int offset, char c) {
        return insert(offset, String.valueOf(c));
    }

    public StringBuilder insert(int offset, int i) {
        return insert(offset, String.valueOf(i));
    }

    public StringBuilder insert(int offset, long l) {
        return insert(offset, String.valueOf(l));
    }

    public StringBuilder insert(int offset, float f) {
        return insert(offset, String.valueOf(f));
    }

    public StringBuilder insert(int offset, double d) {
        return insert(offset, String.valueOf(d));
    }

    public StringBuilder reverse() {
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
