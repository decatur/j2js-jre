package java.io;

/**
 * A character stream that collects its output in a string buffer,
 * which can then be used to construct a string.
 * 
 * @author j2js.com
 */
public class StringWriter extends Writer {
    
    private StringBuffer buffer = new StringBuffer();
    
    /**
     * Return the string buffer itself.
     */
    public StringBuffer getBuffer() {
        return buffer;
    }
    
    /**
     * Write a string.
     */
    public void write(String str) throws IOException {
        buffer.append(str);
    }
}
