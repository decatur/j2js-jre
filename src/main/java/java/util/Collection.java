package java.util;

/**
 * An ordered collection (also known as a sequence).
 * 
 * @author Wolfgang Kuehn
 */
public interface Collection<E> extends Iterable<E> {

    /**
     * Appends the specified element to the end of this collection (optional operation).
     */
    public boolean add(E element);

    /**
     * Removes all of the elements from this collection (optional operation).
     */
    public void clear();
    
    /**
     *  Returns true if this collection contains the specified element.
     */
    public boolean contains(Object value);

    /**
     * Compares the specified object with this collection for equality.
     */
    public boolean equals(Object o);
    
    /**
     * Returns true if this collection contains no elements.
     */
    public boolean isEmpty();
    
    /**
     * Returns an iterator over the elements in this collection in proper sequence.
     */
    public Iterator<E> iterator();

    /**
     * Removes all of the elements from this collection (optional operation).
     */
    public boolean remove(Object elem);

    /**
     * Returns the number of elements in this collection.
     */
    public int size();

    /**
     * Returns an array containing all of the elements in this collection in proper sequence.
     */
    public E[] toArray();
    
    /**
     * Returns an array containing all of the elements in this collection in the correct order.
     */
    public E[] toArray(E[] target);
}