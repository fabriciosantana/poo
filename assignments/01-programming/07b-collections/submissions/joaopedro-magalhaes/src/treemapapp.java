// TreeMapApp.java
import java.util.*;

public class TreeMapApp {
    public static void main(String[] args) {

        TreeMap<Integer, String> mapa = new TreeMap<>();

        // 1
        System.out.println("1. Associate Value with Key");
        mapa.put(1, "Azul");
        mapa.put(2, "Verde");
        mapa.put(3, "Branco");
        mapa.put(4, "Preto");
        System.out.println(mapa);

        // 2
        System.out.println("\n2. Copy TreeMap");
        TreeMap<Integer, String> copia = new TreeMap<>(mapa);
        System.out.println(copia);

        // 3
        System.out.println("\n3. Search Key");
        System.out.println(mapa.containsKey(2));

        // 4
        System.out.println("\n4. Search Value");
        System.out.println(mapa.containsValue("Azul"));

        // 5
        System.out.println("\n5. Get All Keys");
        System.out.println(mapa.keySet());

        // 6
        System.out.println("\n6. Clear TreeMap");
        TreeMap<Integer, String> temp = new TreeMap<>(mapa);
        temp.clear();
        System.out.println(temp);

        // 7
        System.out.println("\n7. Sort Keys with Comparator");
        TreeMap<Integer, String> reverso =
                new TreeMap<>(Collections.reverseOrder());

        reverso.putAll(mapa);
        System.out.println(reverso);

        // 8
        System.out.println("\n8. Greatest and Least Mapping");
        System.out.println(mapa.firstEntry());
        System.out.println(mapa.lastEntry());

        // 9
        System.out.println("\n9. Get First and Last Key");
        System.out.println(mapa.firstKey());
        System.out.println(mapa.lastKey());

        // 10
        System.out.println("\n10. Reverse Key View");
        System.out.println(mapa.descendingKeySet());

        // 11
        System.out.println("\n11. Floor Entry");
        System.out.println(mapa.floorEntry(3));

        // 12
        System.out.println("\n12. Floor Key");
        System.out.println(mapa.floorKey(3));

        // 13
        System.out.println("\n13. Head Map (Exclusive)");
        System.out.println(mapa.headMap(3));

        // 14
        System.out.println("\n14. Head Map (Inclusive Option)");
        System.out.println(mapa.headMap(3, true));

        // 15
        System.out.println("\n15. Higher Key");
        System.out.println(mapa.higherKey(2));

        // 16
        System.out.println("\n16. Lower Entry");
        System.out.println(mapa.lowerEntry(3));

        // 17
        System.out.println("\n17. Lower Key");
        System.out.println(mapa.lowerKey(3));

        // 18
        System.out.println("\n18. NavigableSet View");
        System.out.println(mapa.navigableKeySet());

        // 19
        System.out.println("\n19. Poll First Entry");
        System.out.println(mapa.pollFirstEntry());
        System.out.println(mapa);

        // 20
        System.out.println("\n20. Poll Last Entry");
        System.out.println(mapa.pollLastEntry());
        System.out.println(mapa);

        mapa.put(1, "Azul");
        mapa.put(2, "Verde");
        mapa.put(3, "Branco");
        mapa.put(4, "Preto");

        // 21
        System.out.println("\n21. SubMap (Inclusive to Exclusive)");
        System.out.println(mapa.subMap(1, true, 4, false));

        // 22
        System.out.println("\n22. SubMap (Range)");
        System.out.println(mapa.subMap(2, 4));

        // 23
        System.out.println("\n23. TailMap (Inclusive)");
        System.out.println(mapa.tailMap(2, true));

        // 24
        System.out.println("\n24. TailMap (Exclusive)");
        System.out.println(mapa.tailMap(2, false));

        // 25
        System.out.println("\n25. Ceiling Entry");
        System.out.println(mapa.ceilingEntry(2));

        // 26
        System.out.println("\n26. Ceiling Key");
        System.out.println(mapa.ceilingKey(2));
    }
}