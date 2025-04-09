import java.util.Iterator;

/**
 * A generic doubly linked list implementation.
 * Supports common list operations like add, remove, and get by index.
 * @param <T> the type of elements stored in the list
 */
public class MyLinkedList<T> implements MyList<T>, Iterable<T> {
    private Node head; // Reference to the first node
    private Node tail; // Reference to the last node
    private int size;  // Number of elements in the list

    /**
     * Internal class representing a node in the list.
     * Each node has a reference to the next and previous node.
     */
    private class Node {
        T data;     // The data stored in the node
        Node next;  // Reference to the next node
        Node prev;  // Reference to the previous node

        Node(T data) {
            this.data = data;
        }
    }

    /**
     * Constructs an empty linked list.
     */
    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    /**
     * Adds an item to the end of the list.
     * @param item the element to be added
     */
    @Override
    public void add(T item) {
        Node newNode = new Node(item);
        if (tail == null) {
            // List is empty
            head = tail = newNode;
        } else {
            // Add to the end and update tail
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes the element at the specified index.
     * Handles edge cases: removing head, tail, or middle node.
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            // Remove head
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (index == size - 1) {
            // Remove tail
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            // Remove a middle node
            Node current = getNode(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    /**
     * Returns the element at the specified index.
     * @param index the index of the element
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return getNode(index).data;
    }

    /**
     * Returns the number of elements in the list.
     * @return list size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     * @return true if the list has no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Helper method to retrieve the node at a specific index.
     * Optimized to start from head or tail based on index position.
     * @param index the index of the node
     * @return the node at the given index
     */
    private Node getNode(int index) {
        Node current;
        if (index < size / 2) {
            // Start from head
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // Start from tail
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    /**
     * Returns an iterator for traversing the list.
     * @return an iterator over elements of type T
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }
}
