package java.io;

/**
 * Print formatted representations of objects to a text-output stream.
 * 
 * @author Wolfgang Kuehn
 */
public class PrintWriter {

    /**
     * The underlying character-output stream of this PrintWriter.
     */
    protected Writer out;
    
    private boolean errorState = false;
    
    /**
     * Create a new PrintWriter, without automatic line flushing.
     */
    public PrintWriter(Writer theOut) {
        out = theOut;
    }
    
    /**
     * Flush the stream if it's not closed and check its error state. 
     */
    public boolean checkError() {
        return errorState;
    }

    /**
     * Print a String.
     */
    public void print(String str) {
        try {
            out.write(str);
        } catch (IOException e) {
            setError();
        }
    }
    
    /**
     * Print a String and then terminate the line.
     */
    public void println(String str) {
        print(str);
        print("\n"); 
    }
    
    /**
     * Indicate that an error has occurred.
     */
    protected void setError() {
        errorState = true;   
    }
}
