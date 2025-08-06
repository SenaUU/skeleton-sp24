import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

    @Test
    @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
    public void noNonTrivialFields() {
        List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                .toList();

        assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
    }

    @Test
    public void testAddFirstLast() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        deque.addFirst(0);
        deque.addLast(1);
        deque.addFirst(7);

        assertEquals(deque.get(0), 0);
        assertEquals(deque.get(1), 1);
        assertEquals(deque.get(7), 7);
        assertEquals(deque.size(), 3);
    }

    @Test
    public void testResize() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        for (int i = 0; i <= 8; i++) {
            deque.addLast(i);
        }

        assertEquals(deque.size(), 9);
        assertEquals(deque.get(8), 8);
    }

    @Test
    public void testRemove() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        for (int i = 0; i <= 13; i++) {
            deque.addLast(i);
        }

        assertEquals(deque.removeFirst(), 0);
        assertEquals(deque.removeLast(), 13);
        assertEquals(deque.size(), 12);

        for (int i = 0; i <= 7; i++) {
            deque.removeLast();
        }

        assertEquals(deque.size(), 4);

    }


}
