package java.util;

/**
 * An ordered collection (also known as a sequence).
 * 
 * @author j2js.com
 */
public interface List<T> extends Collection<T> {

    /**
     * Inserts the specified element at the specified position in this list (optional operation).
     */
    public boolean add(int index, T element);

    /**
     * Compares the specified object with this list for equality.
     */
    public boolean equals(Object o);
    
    /**
     * Returns the element at the specified position in this list.
     */
    public T get(int index);

    /**
     * Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
     */
    public int indexOf(Object elem);

    /**
     * Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
     */
    public int lastIndexOf(Object elem);

    /**
     * Removes the element at the specified position in this list (optional operation).
     */
    public T remove(int index);

    /**
     * Replaces the element at the specified position in this list with the specified element (optional operation).
     */
    public T set(int index, T elem);
    
    /**
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
     */
    public List<T> subList(int fromIndex, int toIndex);

}