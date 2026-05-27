import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
    public static void main(String[] args) {
        HashMap<Integer, String> valores = new HashMap<>();
        valores.put(1, "Verde");
        valores.put(2, "Amarelo");
        valores.put(3, "Azul");
        valores.put(4, "Branco");

        System.out.println("1 Associate Key with Value: " + valores);

        int quantidade = valores.size();
        System.out.println("2 Count Key-Value Mappings: " + quantidade);

        HashMap<Integer, String> copia = new HashMap<>(valores);
        System.out.println("3 Copy Mappings to Another Map: " + copia);

        Object clone = valores.clone();
        System.out.println("6 Get Shallow Copy: " + clone);

        boolean existeChave = valores.containsKey(2);
        System.out.println("7 Check If Key Exists: " + existeChave);

        boolean existeValor = valores.containsValue("Azul");
        System.out.println("8 Check If Value Exists: " + existeValor);

        System.out.println("9 Get Entry Set View: " + valores.entrySet());

        String valorPorChave = valores.get(3);
        System.out.println("10 Get Value by Key: " + valorPorChave);

        System.out.println("11 Get Key Set: " + valores.keySet());

        System.out.println("12 Get Values Collection: " + valores.values());

        valores.clear();
        System.out.println("4 Remove All Mappings: " + valores);

        boolean vazio = valores.isEmpty();
        System.out.println("5 Check If Map is Empty: " + vazio);

        for (Map.Entry<Integer, String> entry : copia.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

