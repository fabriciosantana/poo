import java.util.Collections;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        TreeMap<Integer, String> valores = new TreeMap<>();
        valores.put(1, "Um");
        valores.put(2, "Dois");
        valores.put(3, "Tres");
        valores.put(4, "Quatro");
        valores.put(5, "Cinco");
        valores.put(6, "Seis");
        valores.put(7, "Sete");
        valores.put(8, "Oito");
        valores.put(9, "Nove");
        valores.put(10, "Dez");

        System.out.println("1 Associate Value with Key: " + valores);

        TreeMap<Integer, String> copia = new TreeMap<>(valores);
        System.out.println("2 Copy TreeMap: " + copia);

        System.out.println("3 Search Key (5): " + valores.containsKey(5));
        System.out.println("4 Search Value (Cinco): " + valores.containsValue("Cinco"));
        System.out.println("5 Get All Keys: " + valores.keySet());

        TreeMap<Integer, String> comparadorReverso = new TreeMap<>(Collections.reverseOrder());
        comparadorReverso.putAll(valores);
        System.out.println("7 Sort Keys with Comparator: " + comparadorReverso);

        System.out.println("8 Greatest and Least Mapping: " + valores.lastEntry() + " | " + valores.firstEntry());
        System.out.println("9 Get First and Last Key: " + valores.firstKey() + " | " + valores.lastKey());
        System.out.println("10 Reverse Key View: " + valores.descendingKeySet());

        int chave = 6;
        System.out.println("11 Floor Entry: " + valores.floorEntry(chave));
        System.out.println("12 Floor Key: " + valores.floorKey(chave));
        System.out.println("13 Head Map (Exclusive): " + valores.headMap(chave, false));
        System.out.println("14 Head Map (Inclusive Option): " + valores.headMap(chave, true));
        System.out.println("15 Higher Key: " + valores.higherKey(chave));
        System.out.println("16 Lower Entry: " + valores.lowerEntry(chave));
        System.out.println("17 Lower Key: " + valores.lowerKey(chave));
        System.out.println("18 NavigableSet View: " + valores.navigableKeySet());

        TreeMap<Integer, String> paraPoll = new TreeMap<>(valores);
        System.out.println("19 Poll First Entry: " + paraPoll.pollFirstEntry());
        System.out.println("20 Poll Last Entry: " + paraPoll.pollLastEntry());

        System.out.println("21 SubMap (Inclusive to Exclusive): " + valores.subMap(3, true, 7, false));
        System.out.println("22 SubMap (Range): " + valores.subMap(4, true, 8, true));
        System.out.println("23 TailMap (Inclusive): " + valores.tailMap(6, true));
        System.out.println("24 TailMap (Exclusive): " + valores.tailMap(6, false));
        System.out.println("25 Ceiling Entry: " + valores.ceilingEntry(chave));
        System.out.println("26 Ceiling Key: " + valores.ceilingKey(chave));

        TreeMap<Integer, String> limpar = new TreeMap<>(valores);
        limpar.clear();
        System.out.println("6 Clear TreeMap: " + limpar);
    }
}

