import java.util.*;

public class HashMapApp {
    
    public static void main(String[] args) {
        System.out.println("=== Operações com HashMap ===\n");
        
        System.out.println("1. Associate Key with Value:");
        HashMap<String, String> cores = new HashMap<>();
        cores.put("001", "Verde");
        cores.put("002", "Amarelo");
        cores.put("003", "Azul");
        cores.put("004", "Branco");
        System.out.println("HashMap criado: " + cores);
        System.out.println();
        
        System.out.println("2. Count Key-Value Mappings:");
        int quantidade = cores.size();
        System.out.println("Quantidade de pares chave-valor: " + quantidade);
        System.out.println();
        
        System.out.println("3. Copy Mappings to Another Map:");
        HashMap<String, String> copia = new HashMap<>(cores);
        System.out.println("Cópia do HashMap: " + copia);
        System.out.println();
        
        System.out.println("4. Remove All Mappings:");
        HashMap<String, String> copiaParaLimpar = new HashMap<>(cores);
        copiaParaLimpar.clear();
        System.out.println("HashMap após limpeza: " + copiaParaLimpar);
        System.out.println();
        
        System.out.println("5. Check If Map is Empty:");
        boolean vazio = cores.isEmpty();
        System.out.println("HashMap está vazio: " + vazio);
        System.out.println();
        
        System.out.println("6. Get Shallow Copy:");
        HashMap<String, String> copiaSuperficial = (HashMap<String, String>) cores.clone();
        System.out.println("Cópia superficial: " + copiaSuperficial);
        System.out.println();
        
        System.out.println("7. Check If Key Exists:");
        boolean chaveExiste = cores.containsKey("002");
        System.out.println("Chave '002' existe: " + chaveExiste);
        System.out.println();
        
        System.out.println("8. Check If Value Exists:");
        boolean valorExiste = cores.containsValue("Azul");
        System.out.println("Valor 'Azul' existe: " + valorExiste);
        System.out.println();
        
        System.out.println("9. Get Entry Set View:");
        Set<Map.Entry<String, String>> entrySet = cores.entrySet();
        System.out.println("Entry Set:");
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
        
        System.out.println("10. Get Value by Key:");
        String valor = cores.get("003");
        System.out.println("Valor da chave '003': " + valor);
        System.out.println();
        
        System.out.println("11. Get Key Set:");
        Set<String> chaves = cores.keySet();
        System.out.println("Conjunto de chaves: " + chaves);
        System.out.println();
        
        System.out.println("12. Get Values Collection:");
        Collection<String> valores = cores.values();
        System.out.println("Coleção de valores: " + valores);
        
        System.out.println("\n=== Todas as operações concluídas ===");
    }
}
