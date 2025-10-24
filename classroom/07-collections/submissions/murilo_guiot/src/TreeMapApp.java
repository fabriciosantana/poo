import java.util.Comparator;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapApp {

    public static void main(String[] args) {
        
        System.out.println("1. Associate Value with Key");
        TreeMap<Integer, String> mapaCores = new TreeMap<>();
        mapaCores.put(3, "Azul");
        mapaCores.put(1, "Vermelho");
        mapaCores.put(4, "Verde");
        mapaCores.put(2, "Amarelo");
        System.out.println("TreeMap (ordenado por chave): " + mapaCores);
        System.out.println("--------------------");

        System.out.println("2. Copy TreeMap");
        TreeMap<Integer, String> copia = new TreeMap<>();
        copia.putAll(mapaCores);
        System.out.println("Original: " + mapaCores);
        System.out.println("Cópia: " + copia);
        System.out.println("--------------------");

        System.out.println("3. Search Key (Chave 2)");
        System.out.println("Contém chave 2? " + mapaCores.containsKey(2));
        System.out.println("Contém chave 9? " + mapaCores.containsKey(9));
        System.out.println("--------------------");

        System.out.println("4. Search Value (Valor 'Azul')");
        System.out.println("Contém valor 'Azul'? " + mapaCores.containsValue("Azul"));
        System.out.println("Contém valor 'Preto'? " + mapaCores.containsValue("Preto"));
        System.out.println("--------------------");

        System.out.println("5. Get All Keys (KeySet)");
        System.out.println("KeySet (ordenado): " + mapaCores.keySet());
        System.out.println("--------------------");

        System.out.println("6. Clear TreeMap");
        System.out.println("Cópia antes: " + copia);
        copia.clear();
        System.out.println("Cópia depois: " + copia);
        System.out.println("Original (não afetado): " + mapaCores);
        System.out.println("--------------------");

        System.out.println("7. Sort Keys with Comparator (Ordem Reversa)");
        Comparator<Integer> reverseComparator = Collections.reverseOrder();
        TreeMap<Integer, String> mapaReverso = new TreeMap<>(reverseComparator);
        mapaReverso.putAll(mapaCores);
        System.out.println("Mapa Original (ordem natural): " + mapaCores);
        System.out.println("Mapa com Comparator (reverso): " + mapaReverso);
        System.out.println("--------------------");
        
        System.out.println("8. Greatest and Least Mapping (Entry)");
        System.out.println("Menor Mapeamento (firstEntry): " + mapaCores.firstEntry());
        System.out.println("Maior Mapeamento (lastEntry): " + mapaCores.lastEntry());
        System.out.println("--------------------");

        System.out.println("9. Get First and Last Key");
        System.out.println("Menor Chave (firstKey): " + mapaCores.firstKey());
        System.out.println("Maior Chave (lastKey): " + mapaCores.lastKey());
        System.out.println("--------------------");

        System.out.println("10. Reverse Key View (descendingKeySet)");
        System.out.println("Visão das chaves em ordem reversa: " + mapaCores.descendingKeySet());
        System.out.println("Visão do mapa em ordem reversa (descendingMap): " + mapaCores.descendingMap());
        System.out.println("--------------------");

        System.out.println("11. Floor Entry (Chave <= valor)");
        System.out.println("Mapeamento com chave <= 3: " + mapaCores.floorEntry(3));
        System.out.println("Mapeamento com chave <= 2: " + mapaCores.floorEntry(2));
        System.out.println("--------------------");

        System.out.println("12. Floor Key (Chave <= valor)");
        System.out.println("Chave <= 3: " + mapaCores.floorKey(3));
        System.out.println("Chave <= 2: " + mapaCores.floorKey(2));
        System.out.println("--------------------");

        System.out.println("13. Head Map (Exclusive) (< 3)");
        System.out.println("Mapeamentos com chave < 3: " + mapaCores.headMap(3));
        System.out.println("--------------------");

        System.out.println("14. Head Map (Inclusive Option) (<= 3)");
        System.out.println("Mapeamentos com chave <= 3: " + mapaCores.headMap(3, true));
        System.out.println("--------------------");

        System.out.println("15. Higher Key (> 2)");
        System.out.println("Chave > 2: " + mapaCores.higherKey(2));
        System.out.println("--------------------");
        
        System.out.println("16. Lower Entry (< 2)");
        System.out.println("Mapeamento com chave < 2: " + mapaCores.lowerEntry(2));
        System.out.println("--------------------");

        System.out.println("17. Lower Key (< 2)");
        System.out.println("Chave < 2: " + mapaCores.lowerKey(2));
        System.out.println("--------------------");

        System.out.println("18. NavigableSet View (das chaves)");
        NavigableSet<Integer> navigableKeySet = mapaCores.navigableKeySet();
        System.out.println("NavigableSet das Chaves: " + navigableKeySet);
        System.out.println("--------------------");

        System.out.println("19. Poll First Entry");
        TreeMap<Integer, String> tempPoll = new TreeMap<>(mapaCores);
        System.out.println("Mapa 'tempPoll' antes: " + tempPoll);
        Map.Entry<Integer, String> firstEntry = tempPoll.pollFirstEntry();
        System.out.println("Primeiro Entry removido: " + firstEntry);
        System.out.println("Mapa 'tempPoll' depois: " + tempPoll);
        System.out.println("--------------------");

        System.out.println("20. Poll Last Entry");
        System.out.println("Mapa 'tempPoll' antes: " + tempPoll);
        Map.Entry<Integer, String> lastEntry = tempPoll.pollLastEntry();
        System.out.println("Último Entry removido: " + lastEntry);
        System.out.println("Mapa 'tempPoll' depois: " + tempPoll);
        System.out.println("--------------------");

        System.out.println("21. SubMap (Inclusive to Exclusive) [2, 4)");
        System.out.println("SubMapa [2, 4): " + mapaCores.subMap(2, 4));
        System.out.println("--------------------");

        System.out.println("22. SubMap (Range) [2, true, 4, true]");
        System.out.println("SubMapa [2, 4] (ambos inclusivos): " + mapaCores.subMap(2, true, 4, true));
        System.out.println("SubMapa (2, 4) (ambos exclusivos): " + mapaCores.subMap(2, false, 4, false));
        System.out.println("--------------------");

        System.out.println("23. TailMap (Inclusive) (>= 3)");
        System.out.println("Mapeamentos com chave >= 3: " + mapaCores.tailMap(3));
        System.out.println("--------------------");

        System.out.println("24. TailMap (Exclusive) (> 3)");
        System.out.println("Mapeamentos com chave > 3: " + mapaCores.tailMap(3, false));
        System.out.println("--------------------");

        System.out.println("25. Ceiling Entry (>= 2)");
        System.out.println("Mapeamento com chave >= 2: " + mapaCores.ceilingEntry(2));
        System.out.println("Mapeamento com chave >= 0: " + mapaCores.ceilingEntry(0));
        System.out.println("--------------------");

        System.out.println("26. Ceiling Key (>= 2)");
        System.out.println("Chave >= 2: " + mapaCores.ceilingKey(2));
        System.out.println("Chave >= 0: " + mapaCores.ceilingKey(0));
        System.out.println("--------------------");
    }
}
