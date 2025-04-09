import java.util.Iterator;

/**
 * A generic queue implementation using MyLinkedList.
 * Follows FIFO (First-In-First-Out) behavior.
 * @param <T> the type of elements in the queue
 */
public class MyQueue<T> implements Iterable<T> {
    private MyLinkedList<T> list; // Internal linked list to hold queue elements

    /**
     * Constructs an empty queue.
     */
    public MyQueue() {
        list = new MyLinkedList<>();
    }

    /**
     * Adds an item to the end of the queue.
     * @param item the element to enqueue
     */
    public void enqueue(T item) {
        list.add(item); // Add to the tail
    }

    /**
     * Removes and returns the item at the front of the queue.
     * @return the dequeued element
     * @throws IllegalStateException if the queue is empty
     */
    public T dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.get(0);   // Get the front item
        list.remove(0);         // Remove it from the front
        return item;
    }

    /**
     * Returns the item at the front without removing it.
     * @return the front element
     * @throws IllegalStateException if the queue is empty
     */
    public T peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }

    /**
     * Checks whether the queue is empty.
     * @return true if the queue has no elements, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of elements in the queue.
     * @return the size of the queue
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns an iterator to iterate over the queue from front to rear.
     * @return iterator for the queue
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < list.size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                return list.get(currentIndex++);
            }
        };
    }
}
