import java.util.TreeMap;
import java.util.Comparator;
import java.util.NavigableSet;

public class TreeMapApp {

    public static void main(String[] args) {

        TreeMap<Integer, String> colors = new TreeMap<>();
        colors.put(1, "Verde");
        colors.put(2, "Amarelo");
        colors.put(3, "Azul");
        colors.put(4, "Branco");
        colors.put(5, "Preto");
        System.out.println("Associate Value with Key");
        System.out.println(colors);

        TreeMap<Integer, String> copy = new TreeMap<>();
        copy.putAll(colors);
        System.out.println("\nCopy TreeMap");
        System.out.println(copy);

        System.out.println("\nSearch Key");
        System.out.println(colors.containsKey(3));

        System.out.println("\nSearch Value");
        System.out.println(colors.containsValue("Azul"));

        System.out.println("\nGet All Keys");
        System.out.println(colors.keySet());

        TreeMap<Integer, String> reverse = new TreeMap<>(Comparator.reverseOrder());
        reverse.putAll(colors);
        System.out.println("\nSort Keys with Comparator");
        System.out.println(reverse);

        System.out.println(colors.lastEntry());
        System.out.println(colors.firstEntry());

        System.out.println("\nGet First and Last Key");
        System.out.println(colors.firstKey());
        System.out.println(colors.lastKey());

        System.out.println("\nReverse Key View");
        System.out.println(colors.descendingKeySet());

        System.out.println("\nFloor Entry");
        System.out.println(colors.floorEntry(3));

        System.out.println("\nFloor Key");
        System.out.println(colors.floorKey(3));

        System.out.println("\nHead Map Exclusive");
        System.out.println(colors.headMap(4));

        System.out.println("\nHead Map Inclusive");
        System.out.println(colors.headMap(4, true));

        System.out.println("\nHigher Key");
        System.out.println(colors.higherKey(3));

        System.out.println("\nLower Entry");
        System.out.println(colors.lowerEntry(3));

        System.out.println("\nLower Key");
        System.out.println(colors.lowerKey(3));

        System.out.println("\nNavigableSet View");
        NavigableSet<Integer> keys = colors.navigableKeySet();
        System.out.println(keys);

        System.out.println("\nPoll First Entry");
        System.out.println(colors.pollFirstEntry());

        System.out.println(colors);
        System.out.println("\nPoll Last Entry");

        System.out.println(colors.pollLastEntry());
        System.out.println(colors);

        System.out.println("\nSubMap");
        System.out.println(colors.subMap(2, 5));

        System.out.println("\nSubMap Range");
        System.out.println(
            colors.subMap(2, true, 5, true)
        );

        System.out.println("\nTailMap Inclusive");
        System.out.println(colors.tailMap(3, true));

        System.out.println("\nTailMap Exclusive");
        System.out.println(colors.tailMap(3, false));

        System.out.println("\nCeiling Entry");
        System.out.println(colors.ceilingEntry(3));

        System.out.println("\nCeiling Key");
        System.out.println(colors.ceilingKey(3));

    }
}