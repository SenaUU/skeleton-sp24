import java.util.List;
import java.util.ArrayList; // import the ArrayList class

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
        size ++;
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
        size ++;
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
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
