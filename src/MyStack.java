import java.util.Iterator;

/**
 * A generic stack implementation using MyArrayList.
 * Supports typical stack operations: push, pop, peek.
 * Follows LIFO (Last-In-First-Out) behavior.
 * @param <T> the type of elements in the stack
 */
public class MyStack<T> implements Iterable<T> {
    private MyArrayList<T> list; // Internal list used to store elements

    /**
     * Constructs an empty stack.
     */
    public MyStack() {
        list = new MyArrayList<>();
    }

    /**
     * Pushes an item onto the top of the stack.
     * @param item the element to be added
     */
    public void push(T item) {
        list.add(item);
    }

    /**
     * Removes and returns the item at the top of the stack.
     * @return the top element
     * @throws IllegalStateException if the stack is empty
     */
    public T pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = list.get(list.size() - 1);     // Get last item
        list.remove(list.size() - 1);           // Remove it
        return item;
    }

    /**
     * Returns the item at the top of the stack without removing it.
     * @return the top element
     * @throws IllegalStateException if the stack is empty
     */
    public T peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);       // Just return the last item
    }

    /**
     * Checks if the stack is empty.
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of items in the stack.
     * @return stack size
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns an iterator that traverses the stack from top to bottom.
     * @return iterator for stack
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = list.size() - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                return list.get(currentIndex--);
            }
        };
    }
}
