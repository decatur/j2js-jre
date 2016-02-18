package java.util;

/**
 * This class implements the Set interface, backed by a {@link java.util.HashMap}.
 * 
 * @author Wolfgang Kuehn
 */
public class HashSet<E> extends AbstractCollection<E> implements Set<E> {

    private HashMap<E, E> map;
    
    /**
     * Constructs a new, empty set
     */
    public HashSet() {
        map = new HashMap<E, E>();
    }
    
    /**
     * Adds the specified element to this set if it is not already present.
     */
    public boolean add(E element) {
        return map.put(element, element) != element;
    }
    
    /**
     * Removes all of the elements from this collection (optional operation).
     */
    public void clear() {
        map.clear();
    }

    /**
     * Returns true if this set contains the specified element.
     */
    public boolean contains(Object element) {
        return map.containsKey(element);
    }

    /**
     * Returns an iterator over the elements in this set.
     */
    public Iterator<E> iterator() {
        return map.values().iterator();
    }
    
    /**
     * Returns true if this collection contains no elements.
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }
    
    /**
     * Removes all of the elements from this collection (optional operation).
     */
    public boolean remove(Object elem) {
        return map.remove(elem) == elem;
    }
    
    /**
     * Returns the number of elements in this set (its cardinality).
     */
    public int size() {
        return map.size();
    }
    
}
