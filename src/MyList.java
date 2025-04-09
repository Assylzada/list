public interface MyList<T> {
    void add(T item);       // Add an item to the list
    void remove(int index); // Remove the item at the given index
    T get(int index);       // Get the item at the given index
    int size();             // Get the current size of the list
    boolean isEmpty();      // Check if the list is empty
}
