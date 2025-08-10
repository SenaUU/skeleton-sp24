import deque.ArrayDeque61B;
import deque.LinkedListDeque61B;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static com.google.common.truth.Truth.assertThat;

public class IteratorTest {
    @Test
    public void arrayIterator() {
        ArrayDeque61B<Integer> arrayDeque1 = new ArrayDeque61B<>();
        for (int i = 0; i < 9; i++) {
            arrayDeque1.addLast(i);
        }
        for (int i : arrayDeque1) {
            System.out.println(i);
        }
        Iterator<Integer> iter = arrayDeque1.iterator();
        assertTrue(iter.hasNext());
        assertThat(iter.next()).isEqualTo(0);
        assertThat(iter.next()).isEqualTo(1);
    }

    @Test
    public void linkedIterator() {
        LinkedListDeque61B<Integer> linkedDeque1 = new LinkedListDeque61B<>();
        linkedDeque1.addLast(0);
        linkedDeque1.addLast(1);
        linkedDeque1.addLast(2);

        for (int i : linkedDeque1) {
            System.out.println(i);
        }
        Iterator<Integer> iter = linkedDeque1.iterator();
        assertThat(iter.next()).isEqualTo(0);
        assertThat(iter.next()).isEqualTo(1);
        assertThat(iter.next()).isEqualTo(2);
        assertThat(iter.hasNext()).isFalse();
    }
}
