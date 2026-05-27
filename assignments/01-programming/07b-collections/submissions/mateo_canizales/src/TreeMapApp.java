import java.util.Collections;
import java.util.TreeMap;

public class TreeMapApp {

    public static void main(String[] args) {

        TreeMap<Integer, String> mapa = new TreeMap<>();

        System.out.println("1. Associate Value with Key");
        mapa.put(1, "Verde");
        mapa.put(2, "Azul");
        mapa.put(3, "Branco");
        mapa.put(4, "Amarelo");
        System.out.println(mapa);

        System.out.println("\n2. Copy TreeMap");
        TreeMap<Integer, String> copia = new TreeMap<>(mapa);
        System.out.println(copia);

        System.out.println("\n3. Search Key");
        System.out.println(mapa.containsKey(2));

        System.out.println("\n4. Search Value");
        System.out.println(mapa.containsValue("Azul"));

        System.out.println("\n5. Get All Keys");
        System.out.println(mapa.keySet());

        System.out.println("\n6. Clear TreeMap");
        TreeMap<Integer, String> temp = new TreeMap<>(mapa);
        temp.clear();
        System.out.println(temp);

        System.out.println("\n7. Sort Keys with Comparator");
        TreeMap<Integer, String> reverso = new TreeMap<>(Collections.reverseOrder());
        reverso.putAll(mapa);
        System.out.println(reverso);

        System.out.println("\n8. Greatest and Least Mapping");
        System.out.println(mapa.firstEntry());
        System.out.println(mapa.lastEntry());

        System.out.println("\n9. Get First and Last Key");
        System.out.println(mapa.firstKey());
        System.out.println(mapa.lastKey());

        System.out.println("\n10. Reverse Key View");
        System.out.println(mapa.descendingKeySet());

        System.out.println("\n11. Floor Entry");
        System.out.println(mapa.floorEntry(3));

        System.out.println("\n12. Floor Key");
        System.out.println(mapa.floorKey(3));

        System.out.println("\n13. Head Map (Exclusive)");
        System.out.println(mapa.headMap(3));

        System.out.println("\n14. Head Map (Inclusive Option)");
        System.out.println(mapa.headMap(3, true));

        System.out.println("\n15. Higher Key");
        System.out.println(mapa.higherKey(2));

        System.out.println("\n16. Lower Entry");
        System.out.println(mapa.lowerEntry(3));

        System.out.println("\n17. Lower Key");
        System.out.println(mapa.lowerKey(3));

        System.out.println("\n18. NavigableSet View");
        System.out.println(mapa.navigableKeySet());

        System.out.println("\n19. Poll First Entry");
        System.out.println(mapa.pollFirstEntry());
        System.out.println(mapa);

        System.out.println("\n20. Poll Last Entry");
        System.out.println(mapa.pollLastEntry());
        System.out.println(mapa);

        mapa.put(1, "Verde");
        mapa.put(2, "Azul");
        mapa.put(3, "Branco");
        mapa.put(4, "Amarelo");

        System.out.println("\n21. SubMap (Inclusive to Exclusive)");
        System.out.println(mapa.subMap(1, true, 4, false));

        System.out.println("\n22. SubMap (Range)");
        System.out.println(mapa.subMap(2, 4));

        System.out.println("\n23. TailMap (Inclusive)");
        System.out.println(mapa.tailMap(2, true));

        System.out.println("\n24. TailMap (Exclusive)");
        System.out.println(mapa.tailMap(2, false));

        System.out.println("\n25. Ceiling Entry");
        System.out.println(mapa.ceilingEntry(2));

        System.out.println("\n26. Ceiling Key");
        System.out.println(mapa.ceilingKey(2));
    }
}