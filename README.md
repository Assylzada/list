# MyList Project

This repository contains the implementation of various data structures, such as `MyArrayList`, `MyLinkedList`, `MyStack`, `MyQueue`, and `MyMinHeap`, in Java. These custom data structures aim to replicate the behavior of standard Java collections like `ArrayList`, `LinkedList`, `Stack`, `Queue`.

## Data Structures Included

1. **MyArrayList**: A custom implementation of a dynamic array that can grow as needed.
2. **MyLinkedList**: A custom implementation of a doubly linked list.
3. **MyStack**: A custom implementation of a stack data structure using an `ArrayList`.
4. **MyQueue**: A custom implementation of a queue data structure using a `LinkedList`.
5. **MyMinHeap**: A custom implementation of a min-heap, supporting insertion and deletion of the minimum element.

## Features

- **Resizable Arrays**: Both the `MyArrayList` and `MyMinHeap` resize automatically when the underlying data structure is full.
- **Iterator Support**: All data structures implement the `Iterable` interface to allow for easy iteration.
- **Basic Operations**: Common operations such as `add`, `remove`, `get`, and `size` are supported across the data structures.
- **Error Handling**: Methods are designed to throw exceptions (e.g., `IndexOutOfBoundsException` or `IllegalStateException`) when operations are invalid.

## Usage

### MyArrayList
```java
MyArrayList<Integer> list = new MyArrayList<>();
list.add(10);
list.add(20);
System.out.println(list.get(0)); // Output: 10
list.remove(0);
System.out.println(list.size()); // Output: 1
```

### MyLinkedList
```java
MyLinkedList<String> list = new MyLinkedList<>();
list.add("Hello");
list.add("World");
System.out.println(list.get(1)); // Output: World
list.remove(0);
System.out.println(list.size()); // Output: 1
```

### MyStack
```java
MyStack<Integer> stack = new MyStack<>();
stack.push(10);
stack.push(20);
System.out.println(stack.pop()); // Output: 20
System.out.println(stack.peek()); // Output: 10
```

### MyQueue
```java
MyQueue<Integer> queue = new MyQueue<>();
queue.enqueue(10);
queue.enqueue(20);
System.out.println(queue.dequeue()); // Output: 10
System.out.println(queue.peek()); // Output: 20
```

### MyMinHeap
```java
MyMinHeap<Integer> heap = new MyMinHeap<>();
heap.insert(10);
heap.insert(5);
heap.insert(20);
System.out.println(heap.deleteMin()); // Output: 5
```

## Requirements

- Java 8 or higher.

