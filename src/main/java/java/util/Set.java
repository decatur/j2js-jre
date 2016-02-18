package java.util;

/**
 * A collection that contains no duplicate elements.
 */
public interface Set<E> extends Collection<E> {

    /**
     * Adds the specified element to this set if it is not already present.
     */
    public boolean add(E element);

    /**
     * Returns true if this set contains the specified element.
     */
    public boolean contains(Object element);

    /**
     * Returns an iterator over the elements in this set.
     */
    public Iterator<E> iterator();

    /**
     * Returns the number of elements in this set (its cardinality).
     */
    public int size();

}