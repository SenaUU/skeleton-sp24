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
        return List.of(items);
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
            nextLast = Math.floorMod(size, newItems.length);;
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
}
