public class Main {
    public static void main(String[] args) {
        // Test MyArrayList
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        System.out.println("ArrayList size: " + arrayList.size());
        System.out.println("Element at index 1: " + arrayList.get(1));
        arrayList.remove(0);
        System.out.println("ArrayList size after remove: " + arrayList.size());

        // Test MyLinkedList
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println("LinkedList size: " + linkedList.size());
        linkedList.remove(1);
        System.out.println("LinkedList size after remove: " + linkedList.size());

        // Test MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Stack top: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());

        // Test MyQueue
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        System.out.println("Queue front: " + queue.peek());
        System.out.println("Queue dequeue: " + queue.dequeue());

        // Test MyMinHeap
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(2);
        System.out.println("MinHeap deleteMin: " + minHeap.deleteMin());
    }
}
