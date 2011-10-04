package java.io;

public class OutputStreamWriter extends Writer {

    private OutputStream out;
    
    /**
     * Create an OutputStreamWriter that uses the default character encoding.
     */
    public OutputStreamWriter(OutputStream theOut) {
        out = theOut;
    }
    
    public void write(String str) throws IOException {
        out.write(str);
    }
    
}
