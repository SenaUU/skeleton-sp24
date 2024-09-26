import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int size = L.size();
        int sum = 0;
        if(size > 0){
            for (Integer integer : L) {
                sum += integer;
            }
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> evenlist = new ArrayList<>();
        for (int item : L) {
            if (item % 2 == 0) {
                evenlist.add(item);
            }
        }
        return evenlist;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> commonlist = new ArrayList<>();
        for (int item : L1) {
            if (L2.contains(item)) {
                commonlist.add(item);
            }
        }
        return commonlist;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int occurence = 0;
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (c == word.charAt(j)) {
                    occurence++;
                }
            }
        }
        return occurence;
    }
}
