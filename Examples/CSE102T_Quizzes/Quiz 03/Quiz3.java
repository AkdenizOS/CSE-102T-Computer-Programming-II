import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class Quiz3 {
    private static Set<String> myThing1 = new HashSet<>();
    private static Map<String, Integer> myThing2 = new HashMap<>();

    public static boolean isDuplicate(Set<String> thing, String month, int day) {
        String date = month + "-" + day;
        if (thing.contains(date)) {
            return true;
        } else {
            thing.add(date);
            return false;
        }
    }

    public static int countMostSoFar(Map<String, Integer> thing, String month, int day) {
        String date = month + "-" + day;
        thing.put(date, thing.getOrDefault(date, 0) + 1);
        return thing.get(date);
    }

    public static void main(String[] args) {
        String[] myMonths = {"May", "June", "May", "July", "May", "May", "May"};
        int[] myDays = {20, 20, 20, 20, 19, 19, 19};

        for (int i = 0; i < myMonths.length; i++) {
            System.out.println("Adding " + myMonths[i] + "-" + myDays[i]);
            System.out.println(isDuplicate(myThing1, myMonths[i], myDays[i]));
            System.out.println(countMostSoFar(myThing2, myMonths[i], myDays[i]));
        }
    }
}
