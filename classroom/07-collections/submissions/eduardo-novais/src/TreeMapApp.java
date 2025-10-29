import java.util.*;

public class TreeMapApp {
    
    public static void main(String[] args) {
        System.out.println("=== Operações com TreeMap ===\n");
        
        System.out.println("1. Associate Value with Key:");
        TreeMap<String, String> cores = new TreeMap<>();
        cores.put("001", "Verde");
        cores.put("002", "Amarelo");
        cores.put("003", "Azul");
        cores.put("004", "Branco");
        cores.put("005", "Rosa");
        System.out.println("TreeMap criado: " + cores);
        System.out.println();
        
        System.out.println("2. Copy TreeMap:");
        TreeMap<String, String> copia = new TreeMap<>(cores);
        System.out.println("Cópia do TreeMap: " + copia);
        System.out.println();
        
        System.out.println("3. Search Key:");
        boolean chaveExiste = cores.containsKey("003");
        System.out.println("Chave '003' existe: " + chaveExiste);
        System.out.println();
        
        System.out.println("4. Search Value:");
        boolean valorExiste = cores.containsValue("Azul");
        System.out.println("Valor 'Azul' existe: " + valorExiste);
        System.out.println();
        
        System.out.println("5. Get All Keys:");
        Set<String> chaves = cores.keySet();
        System.out.println("Todas as chaves: " + chaves);
        System.out.println();
        
        System.out.println("6. Clear TreeMap:");
        TreeMap<String, String> copiaParaLimpar = new TreeMap<>(cores);
        copiaParaLimpar.clear();
        System.out.println("TreeMap após limpeza: " + copiaParaLimpar);
        System.out.println();
        
        System.out.println("7. Sort Keys with Comparator:");
        TreeMap<String, String> ordenadoReverso = new TreeMap<>(Collections.reverseOrder());
        ordenadoReverso.putAll(cores);
        System.out.println("Chaves em ordem reversa: " + ordenadoReverso);
        System.out.println();
        
        System.out.println("8. Greatest and Least Mapping:");
        Map.Entry<String, String> maior = cores.lastEntry();
        Map.Entry<String, String> menor = cores.firstEntry();
        System.out.println("Maior chave: " + maior.getKey() + " -> " + maior.getValue());
        System.out.println("Menor chave: " + menor.getKey() + " -> " + menor.getValue());
        System.out.println();
        
        System.out.println("9. Get First and Last Key:");
        String primeiraChave = cores.firstKey();
        String ultimaChave = cores.lastKey();
        System.out.println("Primeira chave: " + primeiraChave);
        System.out.println("Última chave: " + ultimaChave);
        System.out.println();
        
        System.out.println("10. Reverse Key View:");
        NavigableSet<String> chavesReversas = cores.descendingKeySet();
        System.out.println("Chaves em ordem reversa: " + chavesReversas);
        System.out.println();
        
        System.out.println("11. Floor Entry:");
        Map.Entry<String, String> floorEntry = cores.floorEntry("003");
        System.out.println("Floor entry para '003': " + floorEntry.getKey() + " -> " + floorEntry.getValue());
        System.out.println();
        
        System.out.println("12. Floor Key:");
        String floorKey = cores.floorKey("003");
        System.out.println("Floor key para '003': " + floorKey);
        System.out.println();
        
        System.out.println("13. Head Map (Exclusive):");
        SortedMap<String, String> headMapExclusive = cores.headMap("003");
        System.out.println("Head map exclusivo para '003': " + headMapExclusive);
        System.out.println();
        
        System.out.println("14. Head Map (Inclusive Option):");
        NavigableMap<String, String> headMapInclusive = cores.headMap("003", true);
        System.out.println("Head map inclusivo para '003': " + headMapInclusive);
        System.out.println();
        
        System.out.println("15. Higher Key:");
        String higherKey = cores.higherKey("002");
        System.out.println("Higher key para '002': " + higherKey);
        System.out.println();
        
        System.out.println("16. Lower Entry:");
        Map.Entry<String, String> lowerEntry = cores.lowerEntry("004");
        System.out.println("Lower entry para '004': " + lowerEntry.getKey() + " -> " + lowerEntry.getValue());
        System.out.println();
        
        System.out.println("17. Lower Key:");
        String lowerKey = cores.lowerKey("004");
        System.out.println("Lower key para '004': " + lowerKey);
        System.out.println();
        
        System.out.println("18. NavigableSet View:");
        NavigableSet<String> navigableSet = cores.navigableKeySet();
        System.out.println("NavigableSet view: " + navigableSet);
        System.out.println();
        
        System.out.println("19. Poll First Entry:");
        Map.Entry<String, String> primeiroPoll = cores.pollFirstEntry();
        System.out.println("Primeiro entry removido: " + primeiroPoll.getKey() + " -> " + primeiroPoll.getValue());
        System.out.println("TreeMap após pollFirstEntry: " + cores);
        System.out.println();
        
        System.out.println("20. Poll Last Entry:");
        Map.Entry<String, String> ultimoPoll = cores.pollLastEntry();
        System.out.println("Último entry removido: " + ultimoPoll.getKey() + " -> " + ultimoPoll.getValue());
        System.out.println("TreeMap após pollLastEntry: " + cores);
        System.out.println();
        
        System.out.println("21. SubMap (Inclusive to Exclusive):");
        SortedMap<String, String> subMap = cores.subMap("001", "003");
        System.out.println("SubMap de '001' (inclusivo) a '003' (exclusivo): " + subMap);
        System.out.println();
        
        System.out.println("22. SubMap (Range):");
        NavigableMap<String, String> subMapRange = cores.subMap("001", true, "003", true);
        System.out.println("SubMap de '001' a '003' (ambos inclusivos): " + subMapRange);
        System.out.println();
        
        System.out.println("23. TailMap (Inclusive):");
        SortedMap<String, String> tailMapInclusive = cores.tailMap("002");
        System.out.println("TailMap inclusivo para '002': " + tailMapInclusive);
        System.out.println();
        
        System.out.println("24. TailMap (Exclusive):");
        NavigableMap<String, String> tailMapExclusive = cores.tailMap("002", false);
        System.out.println("TailMap exclusivo para '002': " + tailMapExclusive);
        System.out.println();
        
        System.out.println("25. Ceiling Entry:");
        Map.Entry<String, String> ceilingEntry = cores.ceilingEntry("002");
        System.out.println("Ceiling entry para '002': " + ceilingEntry.getKey() + " -> " + ceilingEntry.getValue());
        System.out.println();
        
        System.out.println("26. Ceiling Key:");
        String ceilingKey = cores.ceilingKey("002");
        System.out.println("Ceiling key para '002': " + ceilingKey);
        
        System.out.println("\n=== Todas as operações concluídas ===");
    }
}
