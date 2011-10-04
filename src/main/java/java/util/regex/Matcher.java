package java.util.regex;

import javascript.ScriptHelper;

/**
 * An engine that performs match operations on a character sequence by interpreting a Pattern.
 * 
 * @author j2js
 */
public final class Matcher {
/*
var r = new RegExp("[\\[_*!]|(\\|{1,2})", "g")
var m = r.exec("a*b_c");
r.lastIndex = m.index + m[0].length;
m = r.exec("a*b_c");
[m[0], m.index];
 */
    
    private Object nativeRegExp;
    private CharSequence input;
    private Object matchResult;
    
    protected Matcher(Object nativeRegExp, CharSequence input) {
        this.nativeRegExp = nativeRegExp;
        this.input = input;
    }
    
    /**
     * Returns the offset after the last character matched.
     * 
     * @return The offset after the last character matched
     */
    public int end() {
        return ScriptHelper.evalInt("this.matchResult.index + this.matchResult[0].length");
    }


    /**
     * Attempts to find the next subsequence of the input sequence that matches the pattern.
     */
    public boolean find() {
        ScriptHelper.eval("this.matchResult = this.nativeRegExp.exec(this.input)");
        if (matchResult == null) return false;
        ScriptHelper.eval("this.nativeRegExp.lastIndex = this.matchResult.index + this.matchResult[0].length");
        return true;
    }
    
    /**
     * Resets this matcher and then attempts to find the next subsequence of the input sequence that
     * matches the pattern, starting at the specified index.
     * 
     * @return true if, and only if, a subsequence of the input sequence starting at the given index
     *         matches this matcher's pattern
     */
    public boolean find(int start) {
        ScriptHelper.put("start", start);
        ScriptHelper.eval("this.nativeRegExp.lastIndex = start");
        return find();
    }
    
    /**
     * Returns the input subsequence matched by the previous match.
     */
    public String group() {
        return group(0);
    }

    /**
     *  Returns the input subsequence captured by the given group during the previous match operation.
     */
    public String group(int group) {
        if (group > groupCount()) {
            throw new IndexOutOfBoundsException();
        }
        ScriptHelper.put("group", group);
        // We have to convert from 'undefined' to null.
        return (String) ScriptHelper.eval("!this.matchResult[group]?null:this.matchResult[group]");
    }
    
    /**
     * Returns the number of capturing groups in this matcher's pattern.
     * Group zero denotes the entire pattern by convention. It is not included in this count.
     * Any non-negative integer smaller than or equal to the value returned by this method
     * is guaranteed to be a valid group index for this matcher.
     */
    public int groupCount() {
        return ScriptHelper.evalInt("this.matchResult.length-1");
    }

    /**
     * Returns the start index of the previous match.
     * 
     * @return The index of the first character matched
     */
    public int start() {
        return ScriptHelper.evalInt("this.matchResult.index");
    }

    

    
}
