package java.lang;

/**
 * A CharSequence is a readable sequence of char values.
 * 
 * @author j2js
 */
public interface CharSequence {
    
    /**
     * Returns the char value at the specified index.
     */
    public char charAt(int index);

    /*
     * Returns the length of this character sequence.
     */
    public int length();
    
    /*
     * Returns a new CharSequence that is a subsequence of this sequence.
     */
    public CharSequence subSequence(int start, int end);
}
