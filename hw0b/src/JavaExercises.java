import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaExercises {

    /** Returns an array [1, 2, 3, 4, 5, 6] */
    public static int[] makeDice() {
        return new int[]{1,2,3,4,5,6};
    }

    /** Returns the order depending on the customer.
     *  If the customer is Ergun, return ["beyti", "pizza", "hamburger", "tea"].
     *  If the customer is Erik, return ["sushi", "pasta", "avocado", "coffee"].
     *  In any other case, return an empty String[] of size 3. */
    public static String[] takeOrder(String customer) {
        Map<String, String[]> map = new HashMap<>();
        String[] array1 = {"beyti", "pizza", "hamburger", "tea"};
        String[] array2 = {"sushi", "pasta", "avocado", "coffee"};
        String[] array3 = new String[3];
        map.put("Ergun", array1);
        map.put("Erik", array2);
        if(!map.containsKey(customer)){
            return array3;
        }
        return map.get(customer);
    }

    /** Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty. */
    public static int findMinMax(int[] array) {
        int min = array[0];
        int max = array[0];
        for(int i : array){
            if(i > max){
                max = i;
            } else if (i < min){
                min = i;
            }
        }
        return max - min;
    }

    /**
      * Uses recursion to compute the hailstone sequence as a list of integers starting from an input number n.
      * Hailstone sequence is described as:
      *    - Pick a positive integer n as the start
      *        - If n is even, divide n by 2
      *        - If n is odd, multiply n by 3 and add 1
      *    - Continue this process until n is 1
      */
    public static List<Integer> hailstone(int n) {
        return hailstoneHelper(n, new ArrayList<>());
    }

    private static List<Integer> hailstoneHelper(int x, List<Integer> list) {
        if(x==1){
            return list;
        } else if(x%2 == 0){
            x = x/2;
        } else{
            x = 3*x+1;
        }
        list.add(x);
        return hailstoneHelper(x, list);
    }

}
