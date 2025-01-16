import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {

     @Test
     /** In this test, we have three different assert statements that verify that addFirst works correctly. */
     public void addFirstTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addFirst("back"); // after this call we expect: ["back"]
         assertThat(lld1.toList()).containsExactly("back").inOrder();

         lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
         assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

         lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

         /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
            but not ["front", "middle", "back"].
          */
     }

     @Test
     /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
      *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
     public void addLastTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addLast("front"); // after this call we expect: ["front"]
         lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
         lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
     }

     @Test
     /** This test performs interspersed addFirst and addLast calls. */
     public void addFirstAndAddLastTest() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose. */
         lld1.addLast(0);   // [0]
         lld1.addLast(1);   // [0, 1]
         lld1.addFirst(-1); // [-1, 0, 1]
         lld1.addLast(2);   // [-1, 0, 1, 2]
         lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

         assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
     }

     // Below, you'll write your own tests for LinkedListDeque61B.
     @Test
     public void testIsEmpty(){
         Deque61B<Object> deque = new LinkedListDeque61B<>();

         // Perform the test for increasing sizes
         for (int i = 0; i <= 100000; i += 10000) {
             // Add elements to the deque
             while (deque.size() < i) {
                 deque.addLast(new Object());
             }

             // Measure the time it takes to call isEmpty()
             long startTime = System.nanoTime();
             deque.isEmpty();
             long endTime = System.nanoTime();

             long duration = endTime - startTime;

             // Optionally, print the execution time for each size
             System.out.println("Size: " + i + ", Time for isEmpty: " + duration + " ns");
         }
    }

    @Test
    public void removeFirstAndAddLastTest() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addFirst(0);
        lld1.addFirst(1);
        lld1.addFirst(2);
        lld1.addFirst(3);
        lld1.addFirst(4);
        lld1.addFirst(5);

        lld1.removeLast();
        lld1.removeLast();
        lld1.removeFirst();

        assertThat(lld1.toList()).containsExactly(4,3,2).inOrder();
    }

    @Test
    public void getAndGetRecursiveTest() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(11);
        lld1.addLast(12);
        lld1.addLast(13);

        int getIndex0 = lld1.get(0);
        Object getIndex5 = lld1.get(5);
        int getRecursiveIndex2 = lld1.getRecursive(2);
        Object getRecursiveIndexBelow0 = lld1.getRecursive(-2);

        assertThat(getIndex0).isEqualTo(10);
        assertThat(getIndex5).isNull();
        assertThat(getRecursiveIndex2).isEqualTo(12);
        assertThat(getRecursiveIndexBelow0).isNull();
    }
}