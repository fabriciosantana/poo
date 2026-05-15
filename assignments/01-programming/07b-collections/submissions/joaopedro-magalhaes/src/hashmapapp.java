// HashMapApp.java
import java.util.*;

public class HashMapApp {
    public static void main(String[] args) {

        HashMap<Integer, String> mapa = new HashMap<>();

        // 1
        System.out.println("1. Associate Key with Value");
        mapa.put(1, "Azul");
        mapa.put(2, "Verde");
        mapa.put(3, "Branco");
        System.out.println(mapa);

        // 2
        System.out.println("\n2. Count Key-Value Mappings");
        System.out.println(mapa.size());

        // 3
        System.out.println("\n3. Copy Mappings to Another Map");
        HashMap<Integer, String> copia = new HashMap<>(mapa);
        System.out.println(copia);

        // 4
        System.out.println("\n4. Remove All Mappings");
        HashMap<Integer, String> temp = new HashMap<>(mapa);
        temp.clear();
        System.out.println(temp);

        // 5
        System.out.println("\n5. Check If Map is Empty");
        System.out.println(temp.isEmpty());

        // 6
        System.out.println("\n6. Get Shallow Copy");
        HashMap<Integer, String> clone = (HashMap<Integer, String>) mapa.clone();
        System.out.println(clone);

        // 7
        System.out.println("\n7. Check If Key Exists");
        System.out.println(mapa.containsKey(2));

        // 8
        System.out.println("\n8. Check If Value Exists");
        System.out.println(mapa.containsValue("Azul"));

        // 9
        System.out.println("\n9. Get Entry Set View");
        System.out.println(mapa.entrySet());

        // 10
        System.out.println("\n10. Get Value by Key");
        System.out.println(mapa.get(1));

        // 11
        System.out.println("\n11. Get Key Set");
        System.out.println(mapa.keySet());

        // 12
        System.out.println("\n12. Get Values Collection");
        System.out.println(mapa.values());
    }
}