import java.util.Arrays;

public class SimulatedSet {

    public static int[] addItem(int[] set, int item) {
        // Öğenin dizide olup olmadığını kontrol et
        for (int i : set) {
            if (i == item) {
                return set; // Öğeyi zaten içeriyorsa orijinal diziyi döndür
            }
        }

        // Öğeyi eklemek için yeni bir dizi oluştur
        int[] newSet = Arrays.copyOf(set, set.length + 1);
        newSet[set.length] = item;
        return newSet;
    }

    public static int countItems(int[] set) {
        return set.length;
    }

    public static String listItems(int[] set) {
        StringBuilder items = new StringBuilder();
        for (int item : set) {
            items.append(item).append(" ");
        }
        return items.toString().trim();
    }

    public static void main(String[] args) {
        int[] set = new int[0];

        set = addItem(set, 1);
        set = addItem(set, 2);
        set = addItem(set, 3);
        set = addItem(set, 3); // Zaten var
        set = addItem(set, 4);

        System.out.println(countItems(set)); // 4
        System.out.println(listItems(set)); // 1 2 3 4

        set = addItem(set, 5);
        set = addItem(set, 3); // Zaten var
        set = addItem(set, 1); // Zaten var

        System.out.println(countItems(set)); // 5
        System.out.println(listItems(set)); // 1 2 3 4 5
    }
}
