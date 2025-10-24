import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapApp {

    public static void main(String[] args) {
        
        System.out.println("1. Associate Key with Value");
        HashMap<Integer, String> mapaCores = new HashMap<>();
        
        
        mapaCores.put(1, "Vermelho");
        mapaCores.put(2, "Verde");
        mapaCores.put(3, "Azul");
        mapaCores.put(4, "Amarelo");
        System.out.println("HashMap: " + mapaCores);
        System.out.println("--------------------");

        
        
        System.out.println("2. Count Key-Value Mappings");
        System.out.println("Tamanho (número de pares): " + mapaCores.size());
        System.out.println("--------------------");

        System.out.println("3. Copy Mappings to Another Map");
        HashMap<Integer, String> copia = new HashMap<>();
        
        copia.putAll(mapaCores);
        System.out.println("Mapa Original: " + mapaCores);
        System.out.println("Mapa Cópia: " + copia);
        System.out.println("--------------------");

        System.out.println("4. Remove All Mappings");
        
        System.out.println("Cópia antes de limpar: " + copia);
        copia.clear();
        System.out.println("Cópia após limpar: " + copia);
        System.out.println("Original (não afetado): " + mapaCores);
        System.out.println("--------------------");

        System.out.println("5. Check If Map is Empty");
        System.out.println("Mapa 'mapaCores' está vazio? " + mapaCores.isEmpty());
        System.out.println("Mapa 'copia' está vazio? " + copia.isEmpty());
        System.out.println("--------------------");

        System.out.println("6. Get Shallow Copy (Clone)");
        
        HashMap<Integer, String> clone = (HashMap<Integer, String>) mapaCores.clone();
        System.out.println("Original: " + mapaCores);
        System.out.println("Clone: " + clone);
        System.out.println("--------------------");

        System.out.println("7. Check If Key Exists (Chave 3)");
        boolean existeChave = mapaCores.containsKey(3);
        System.out.println("Contém chave 3? " + existeChave);
        System.out.println("Contém chave 99? " + mapaCores.containsKey(99));
        System.out.println("--------------------");

        System.out.println("8. Check If Value Exists (Valor 'Verde')");
        boolean existeValor = mapaCores.containsValue("Verde");
        System.out.println("Contém valor 'Verde'? " + existeValor);
        System.out.println("Contém valor 'Preto'? " + mapaCores.containsValue("Preto"));
        System.out.println("--------------------");

        System.out.println("9. Get Entry Set View");
        
        Set<Map.Entry<Integer, String>> entrySet = mapaCores.entrySet();
        System.out.println("EntrySet: " + entrySet);
        
        System.out.println("Iterando sobre o EntrySet:");
        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("--------------------");

        System.out.println("10. Get Value by Key (Chave 2)");
        
        String valor = mapaCores.get(2);
        System.out.println("Valor da chave 2: " + valor);
        System.out.println("Valor da chave 99: " + mapaCores.get(99));
        System.out.println("--------------------");

        System.out.println("11. Get Key Set");
        Set<Integer> keySet = mapaCores.keySet();
        System.out.println("KeySet: " + keySet);
        System.out.println("--------------------");

        System.out.println("12. Get Values Collection");
        Collection<String> values = mapaCores.values();
        System.out.println("Values Collection: " + values);
        System.out.println("--------------------");
    }
}