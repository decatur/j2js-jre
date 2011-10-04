package java.util;

public class EventObject {

    private Object source;
    
    /**
     * Warning: This constructor is not defined by the SWT API. Do not use it!
     */
    public EventObject(Object theSource) {
        source = theSource;
    }

    /**
     * The object on which the Event initially occurred.
     */
    public Object getSource() {
        return source;
    }

    /**
     * Returns a String representation of this EventObject.
     */
    public String toString() {
        String unQualifiedClassName = getClass().getName().replaceAll(".*\\.", "");
        return  unQualifiedClassName + "{" + source.toString() + "}";
    }

}
