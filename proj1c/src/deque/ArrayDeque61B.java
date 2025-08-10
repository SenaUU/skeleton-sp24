package deque;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T> {

    private int nextFirst;
    private int nextLast;
    private int size;
    private T[] items;

    public ArrayDeque61B() {
        this.nextFirst = 0;
        this.nextLast = 1;
        this.size = 0;
        this.items = (T[]) new Object[8];
    }

    @Override
    public void addFirst(T x) {
        if (size == items.length) {
            T[] newItems = (T[]) new Object[size + 8];
            int pointer = Math.floorMod(nextFirst + 1, items.length);
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[pointer];
                pointer = Math.floorMod(pointer + 1, items.length);
            }
            nextFirst = size + 7;
            nextLast = size;
            items = newItems;
        }
        items[nextFirst] = x;
        nextFirst = Math.floorMod(nextFirst - 1, items.length);
        size += 1;
    }

    @Override
    public void addLast(T x) {
        if (size == items.length) {
            T[] newItems = (T[]) new Object[size + 8];
            int pointer = Math.floorMod(nextFirst + 1, items.length);
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[pointer];
                pointer = Math.floorMod(pointer + 1, items.length);
            }
            nextFirst = size + 7;
            nextLast = size;
            items = newItems;
        }
        items[nextLast] = x;
        nextLast = Math.floorMod(nextLast + 1, items.length);
        size += 1;
    }

    @Override
    public List<T> toList() {
        int pointer = nextFirst;
        List<T> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            pointer = Math.floorMod(pointer + 1, items.length);
            array.add(items[pointer]);
        }
        return array;
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
        nextFirst = Math.floorMod(nextFirst + 1, items.length);
        T output = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        if (size <= items.length - 8) {
            T[] newItems = (T[]) new Object[size - 8];
            int pointer = Math.floorMod(nextFirst + 1, items.length);
            for (int i = 0; i < size; i++) {
                newItems[i] = items[pointer];
                pointer = Math.floorMod(pointer + 1, items.length);
            }
            nextFirst = newItems.length - 1;
            nextLast = Math.floorMod(size, newItems.length);
            items = newItems;
        }
        return output;
    }

    @Override
    public T removeLast() {
        nextLast = Math.floorMod(nextLast - 1, items.length);
        T output = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        if (size <= items.length - 8) {
            T[] newItems = (T[]) new Object[items.length - 8];
            int pointer = Math.floorMod(nextFirst + 1, items.length);
            for (int i = 0; i < size; i++) {
                newItems[i] = items[pointer];
                pointer = Math.floorMod(pointer + 1, items.length);
            }
            nextFirst = newItems.length - 1;
            nextLast = Math.floorMod(size, newItems.length);
            items = newItems;
        }
        return output;
    }

    @Override
    public T get(int index) {
        return items[index];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int pointer;
        public ArrayDequeIterator() {
            pointer = Math.floorMod(nextFirst + 1, items.length);
        }
        public boolean hasNext() {
            boolean hasNext = true;
            if (pointer == nextLast) {
                hasNext = false;
            }
            return hasNext;
        }
        public T next() {
            T returnItem = items[pointer];
            pointer++;
            return returnItem;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ArrayDeque61B<?> otherDeque) {
            if (this.size != otherDeque.size) {
                return false;
            }

            int pointer = this.nextFirst;
            int otherPointer = otherDeque.nextFirst;

            for (int i = 0; i < this.size; i++) {
                pointer = Math.floorMod(pointer + 1, this.items.length);
                otherPointer = Math.floorMod(otherPointer + 1, otherDeque.items.length);

                if (this.get(pointer) != otherDeque.get(otherPointer)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.toList().toString();
    }
}

