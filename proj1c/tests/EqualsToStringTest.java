import deque.ArrayDeque61B;
import deque.LinkedListDeque61B;
import org.junit.Test;
import static org.junit.Assert.*;

public class EqualsToStringTest {
    @Test
    public void equalsTest() {
        LinkedListDeque61B<Integer> linkedDeque1 = new LinkedListDeque61B<>();
        linkedDeque1.addLast(0);
        linkedDeque1.addLast(1);
        linkedDeque1.addLast(2);

        LinkedListDeque61B<Integer> linkedDeque2 = new LinkedListDeque61B<>();
        linkedDeque2.addFirst(2);
        linkedDeque2.addFirst(1);
        linkedDeque2.addFirst(0);

        assertEquals(linkedDeque1, linkedDeque2);

        ArrayDeque61B<Integer> arrayDeque1 = new ArrayDeque61B<>();
        for (int i = 0; i < 9; i++) {
            arrayDeque1.addLast(i);
        }

        ArrayDeque61B<Integer> arrayDeque2 = new ArrayDeque61B<>();
        for (int i = 8; i >= 0; i--) {
            arrayDeque2.addFirst(i);
        }

        assertEquals(arrayDeque1, arrayDeque2);
    }

    @Test
    public void toStringTest() {
        LinkedListDeque61B<Integer> linkedDeque1 = new LinkedListDeque61B<>();
        linkedDeque1.addLast(0);
        linkedDeque1.addLast(1);
        linkedDeque1.addLast(2);
        String strLinked = linkedDeque1.toString();
        assertEquals(strLinked, "[0, 1, 2]");

        ArrayDeque61B<Integer> arrayDeque1 = new ArrayDeque61B<>();
        for (int i = 0; i < 4; i++) {
            arrayDeque1.addLast(i);
        }
        String strArray = arrayDeque1.toString();
        assertEquals(strArray, "[0, 1, 2, 3]");
    }
}
