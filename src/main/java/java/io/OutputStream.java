/*
 * Copyright (c) 2005 Wolfgang Kuehn
 */

package java.io;

/**
 * This abstract class is the superclass of all classes representing an output stream of bytes. An output stream accepts output bytes and sends them to some sink.
 */
public abstract class OutputStream {

    private boolean isClosed = false;
    
    /** 
     *
     */
    public OutputStream() {}

    /** 
     * Writes the specified byte to this output stream. The general contract for write is that one byte
     * is written to the output stream. The byte to be written is the eight low-order bits of the argument b.
     * The 24 high-order bits of b are ignored.
     * Subclasses of OutputStream must provide an implementation for this method. 
     */
    public abstract void write(int b) throws IOException;
    
    /**
     * <b>IMPORTANT</b>: This method is not part of the public API.
     * It is marked public only so that it can be shared within the packages provided by J2JS.
     * It is not available on all platforms, and should never be called from application code.
     */
    public abstract void write(String s) throws IOException;

    /** 
     * Writes b.length bytes from the specified byte array to this output stream.
     */
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    /** 
     * Writes len bytes from the specified byte array starting at offset off to this output stream.
     */
    public void write(byte[] b, int off, int len) throws IOException {
        for (int i=0; i<len; i++) {
            write(b[i+off]);
        }   
    }

    /** 
     * Flushes this output stream and forces any buffered output bytes to be written out.
     */
    public void flush() throws IOException {
        ensureOpen();
    }

    /** 
     * Closes this output stream and releases any system resources associated with this stream.
     */
    public void close() {
        isClosed = true;
    }
    
    private void ensureOpen() throws IOException {
        if (isClosed) {
            throw new IOException("Stream is closed");
        }
    }
}
