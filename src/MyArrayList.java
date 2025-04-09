import java.util.Iterator;

/**
 * A generic implementation of a dynamic array list.
 * This class supports adding, removing, accessing, and updating elements.
 * @param <T> the type of elements stored in the list
 */
public class MyArrayList<T> implements MyList<T>, Iterable<T> {
    private Object[] array; // Internal array to store elements
    private int size;       // Current number of elements

    /**
     * Constructs an empty list with an initial capacity of 10.
     */
    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    /**
     * Adds an item to the end of the list.
     * Resizes the array if necessary.
     * @param item the item to add
     */
    @Override
    public void add(T item) {
        if (size == array.length) {
            resize(); // Double the capacity when full
        }
        array[size++] = item;
    }

    /**
     * Removes the element at the specified index.
     * Shifts the remaining elements to the left.
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // Shift elements left to fill the gap
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null; // Clear the last element and reduce size
    }

    /**
     * Returns the element at the specified index.
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) array[index];
    }

    /**
     * Returns the number of elements in the list.
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if the list contains no elements.
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Resizes the internal array to double its current capacity.
     */
    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size); // Copy existing elements
        array = newArray;
    }

    /**
     * Returns an iterator over the elements in the list.
     * @return an iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                return (T) array[currentIndex++];
            }
        };
    }

    /**
     * Updates the value at the specified index.
     * @param index the index to update
     * @param item the new value to set
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        array[index] = item;
    }
}
