import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BirthMonthYear {

    public static void addBirthMonthYear(Map<Integer, Map<String, ArrayList<String>>> bdMap,
                                         String name,
                                         int year,
                                         String month) {
        // Eğer yıl map'te yoksa, yeni bir yıl ve buna bağlı aylar için boş bir map ekleyin
        if (!bdMap.containsKey(year)) {
            bdMap.put(year, new HashMap<>());
        }

        // Yıl map'ini alın
        Map<String, ArrayList<String>> monthMap = bdMap.get(year);

        // Eğer ay map'te yoksa, yeni bir ay ve buna bağlı isimler için boş bir liste ekleyin
        if (!monthMap.containsKey(month)) {
            monthMap.put(month, new ArrayList<>());
        }

        // Ay map'ini alın ve ismi listeye ekleyin
        monthMap.get(month).add(name);
    }

    public static void main(String[] args) {
        Map<Integer, Map<String, ArrayList<String>>> bdMap = new HashMap<>();

        addBirthMonthYear(bdMap, "Ann", 1979, "January");
        addBirthMonthYear(bdMap, "Joseph", 1979, "June");
        addBirthMonthYear(bdMap, "Elijah", 2009, "July");
        addBirthMonthYear(bdMap, "Grace", 2012, "July");
        addBirthMonthYear(bdMap, "Joshua", 2012, "July");

        System.out.println(bdMap);
    }
}
