package java.util;

public interface Comparator<T> {
    /**
     * Compares its two arguments for order. 
     * Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    public int compare(T o1, T o2);
    
    /**
     * Indicates whether some other object is "equal to" this Comparator.
     */ 
    public boolean equals(Object obj);
}
