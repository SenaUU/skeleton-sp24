package deque;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList; // import the ArrayList class
import java.util.NoSuchElementException;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private class Node {
        public T item;
        public Node next;
        public Node prev;

        private Node(T x) {
            item = x;
            next = null;
            prev = null;
        }

    }

    private final Node sentinel;
    private int size;

    public LinkedListDeque61B() {
        sentinel = new Node(null);
        sentinel.prev = sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node newNode = new Node(x);
        if (size == 0) {
            sentinel.prev = sentinel.next = newNode;
            newNode.prev = newNode.next = sentinel;
        } else {
            newNode.next = sentinel.next;
            sentinel.next.prev = newNode;
            newNode.prev = sentinel;
            sentinel.next = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x);
        if (size == 0) {
            sentinel.prev = sentinel.next = newNode;
            newNode.prev = newNode.next = sentinel;
        } else {
            sentinel.prev.next = newNode;
            newNode.prev = sentinel.prev;
            newNode.next = sentinel;
            sentinel.prev = newNode;
        }
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node start = sentinel.next;
        for (int i = 0; i < size; i++) {
            returnList.add(start.item);
            start = start.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size > 0) {

            sentinel.next = sentinel.next.next;
            sentinel.next.next.prev = sentinel;
            size--;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (size > 0) {
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size--;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (index >= 0 & index < size) {
            Node result = sentinel.next;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            return result.item;
        }
        return null;
    }

    @Override
    public T getRecursive(int index) {
        if (index == 0) {
            return sentinel.next.item;
        } else if (index > 0 & index < size) {
            sentinel.next = sentinel.next.next;
            return getRecursive(index - 1);
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LinkedListDeque61B<?> otherDeque) {
            if (this.size != otherDeque.size) {
                return false;
            }
            for (int i = 0; i < this.size; i++)
                if (this.get(i) != otherDeque.get(i)) {
                    return false;
                }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.toList().toString();
    }


    private class LinkedListIterator implements Iterator<T> {
        private Node pointer;

        public LinkedListIterator() {
            pointer = sentinel.next;  // Start at first real node
        }

        public boolean hasNext() {
            return pointer != sentinel;  // Check if we're back to sentinel
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T returnItem = pointer.item;
            pointer = pointer.next;  // Move to next node
            return returnItem;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

}
