package java.util;

public class Collections {
    

    private static class IteratorEnumarator<E> implements Enumeration<E> {
        
        Iterator<E> iterator;
        
        IteratorEnumarator(Iterator<E> theIterator) {
             iterator = theIterator;
        }
        
        public boolean hasMoreElements() {
            return iterator.hasNext();
        }
        
        public E nextElement() {
            if (!iterator.hasNext()) {
                throw new NoSuchElementException();
            }
            return iterator.next();
        }
    }
    
    /**
     * Returns an enumeration over the specified collection. This provides interoperatbility with legacy APIs that require an enumeration as input.
     */
    public static Enumeration enumeration(Collection c) {
        return new IteratorEnumarator(c.iterator());
    }

        
    private static Random r = new Random();
    /**
     * Randomly permutes the specified list using a default source of randomness.
     */
    public static void shuffle(List<?> list) {
        int size = list.size();
        for (int i=size; i>1; i--) {
            swap(list, i-1, r.nextInt(i));
        }
    }

    /**
     *  Sorts the specified list into ascending order, according to the natural ordering of its elements.
     *  <br/>
     *  <b>Important</b>: This is a restriction of the Java API sort(List<T>) function.
     */
    public static void sort(List<String> list) {
        String[] array = list.toArray();
        Arrays.sort(array);
        int count = array.length;
        list.clear();
        for (int i=0; i<count; i++) {
            list.add(array[i]);
        }
    }
    
    /**
     * Swaps the two specified elements in the specified array.
     */
    public static void swap(List<?> list, int i, int j) {
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }
    
}
