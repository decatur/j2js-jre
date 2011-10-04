package java.lang;

public final class Byte extends Number {

    public static final Class<Byte> TYPE = null;
    
    private byte value;
    
    /**
     * Constructs a newly allocated Byte object that represents the specified byte value.
     */
    public Byte(byte value) {
        this.value = value;
    }
    
    /**
     * Compares this object to the specified object.
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Byte)) return false;
        return ((Byte) obj).value == value;
    }

    public double doubleValue() {
        return (double) value;
    }

    public float floatValue() {
        return (float) value;
    }

    public int intValue() {
        return (int) value;
    }

    public long longValue() {
        return (long) value;
    }
    
    /**
     * Returns a String object representing this Byte's value.
     */
    public String toString() {
        return String.valueOf(value);
    }
    
}
