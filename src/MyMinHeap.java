import java.util.Iterator;

/**
 * A generic Min-Heap implementation using MyArrayList.
 * Maintains the heap property: parent <= children.
 * @param <T> the type of elements, must be Comparable
 */
public class MyMinHeap<T extends Comparable<T>> implements Iterable<T> {
    private MyArrayList<T> heap; // Internal dynamic array to store heap elements

    /**
     * Constructs an empty Min-Heap.
     */
    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    /**
     * Inserts a new item into the heap and rebalances it.
     * @param item the element to be inserted
     */
    public void insert(T item) {
        heap.add(item);  // Add the item to the end
        heapifyUp();     // Rebalance heap from bottom to top
    }

    /**
     * Removes and returns the minimum element (root) from the heap.
     * @return the smallest element in the heap
     * @throws IllegalStateException if the heap is empty
     */
    public T deleteMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        T min = heap.get(0);  // The root element (minimum)
        T lastItem = heap.get(heap.size() - 1); // Last item in heap

        heap.remove(heap.size() - 1); // Remove the last item

        // Replace root with last item and heapify down if not empty
        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            heapifyDown();
        }

        return min;
    }

    /**
     * Restores heap property by moving the last added element up.
     */
    private void heapifyUp() {
        int index = heap.size() - 1;
        while (index > 0 && heap.get(index).compareTo(heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2); // Swap with parent if smaller
            index = (index - 1) / 2;
        }
    }

    /**
     * Restores heap property by pushing the root element down.
     */
    private void heapifyDown() {
        int index = 0;
        while (2 * index + 1 < heap.size()) {
            int smallerChild = 2 * index + 1; // Left child

            // If right child exists and is smaller than left, use it
            if (smallerChild + 1 < heap.size() &&
                    heap.get(smallerChild).compareTo(heap.get(smallerChild + 1)) > 0) {
                smallerChild = smallerChild + 1;
            }

            // If current is smaller or equal, stop
            if (heap.get(index).compareTo(heap.get(smallerChild)) <= 0) {
                break;
            }

            swap(index, smallerChild); // Swap with smaller child
            index = smallerChild;
        }
    }

    /**
     * Swaps two elements in the heap array.
     */
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Returns an iterator for the heap elements in array order.
     * @return iterator over heap elements
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < heap.size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                return heap.get(currentIndex++);
            }
        };
    }
}
