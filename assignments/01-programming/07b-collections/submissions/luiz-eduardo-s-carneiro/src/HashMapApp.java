import java.util.HashMap;
import java.util.Map;

public class HashMapApp{
    
    public static void main(String[] args){
        HashMap<Integer, String> colors = new HashMap<>();

        System.out.println("Associate Key with Value");
        colors.put(1, "Verde");
        colors.put(2, "Amarelo");
        colors.put(3, "Azul");
        colors.put(4, "Branco");
        System.out.println(colors);

        System.out.println("\nCount Key-Value Mappings");
        System.out.println(colors.size());

        System.out.println("\nCopy Mappings to Another Map");
        HashMap<Integer, String> colorsCopy = new HashMap<>();
        colorsCopy.putAll(colors);
        System.out.println(colorsCopy);

        System.out.println("\nRemove All Mappings");
        colorsCopy.clear();
        System.out.println(colorsCopy);

        System.out.println("\nCheck If Map is Empty");
        System.out.println(colorsCopy.isEmpty());

        System.out.println("\nGet Shallow Copy");
        HashMap<Integer, String> clone = (HashMap<Integer, String>) colors.clone();
        System.out.println(clone);

        System.out.println("\nCheck If Key Exists");
        System.out.println(colors.containsKey(2));

        System.out.println("\nCheck If Value Exists");
        System.out.println(colors.containsValue("Azul"));

        System.out.println("\nGet Entry Set View");
        System.out.println(colors.entrySet());

        System.out.println("\nGet Value by Key");
        System.out.println(colors.get(3));

        System.out.println("\nGet Key Set");
        System.out.println(colors.keySet());

        System.out.println("\nGet Values Collection");
        System.out.println(colors.values());
    }
}