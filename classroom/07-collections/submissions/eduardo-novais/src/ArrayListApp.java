import java.util.*;

public class ArrayListApp {
    
    public static void main(String[] args) {
        System.out.println("=== Operações com ArrayList ===\n");
        
        System.out.println("1. Create and Print ArrayList:");
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println("Lista criada: " + cores);
        System.out.println();
        
        System.out.println("2. Iterate ArrayList Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println();
        
        System.out.println("3. Insert at First Position:");
        cores.add(0, "Vermelho");
        System.out.println("Após inserir 'Vermelho' na posição 0: " + cores);
        System.out.println();
        
        System.out.println("4. Retrieve Element by Index:");
        if (cores.size() > 2) {
            String elemento = cores.get(2);
            System.out.println("Elemento no índice 2: " + elemento);
        } else {
            System.out.println("Índice 2 não existe na lista");
        }
        System.out.println();
        
        System.out.println("5. Update ArrayList Element:");
        String elementoAntigo = cores.set(1, "Rosa");
        System.out.println("Elemento substituído: " + elementoAntigo);
        System.out.println("Lista após substituição: " + cores);
        System.out.println();
        
        System.out.println("6. Remove Third Element:");
        if (cores.size() > 2) {
            String removido = cores.remove(2);
            System.out.println("Elemento removido: " + removido);
            System.out.println("Lista após remoção: " + cores);
        } else {
            System.out.println("Não há terceiro elemento para remover");
        }
        System.out.println();
        
        System.out.println("7. Search Element in ArrayList:");
        boolean encontrado = cores.contains("Azul");
        System.out.println("'Azul' está na lista: " + encontrado);
        System.out.println();
        
        System.out.println("8. Sort ArrayList:");
        Collections.sort(cores);
        System.out.println("Lista ordenada: " + cores);
        System.out.println();
        
        System.out.println("9. Copy ArrayList:");
        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println("Cópia da lista: " + copia);
        System.out.println();
        
        System.out.println("10. Shuffle ArrayList:");
        Collections.shuffle(cores);
        System.out.println("Lista embaralhada: " + cores);
        System.out.println();
        
        System.out.println("11. Reverse ArrayList:");
        Collections.reverse(cores);
        System.out.println("Lista invertida: " + cores);
        System.out.println();
        
        System.out.println("12. Extract Sublist from ArrayList:");
        if (cores.size() >= 2) {
            List<String> sublista = cores.subList(0, 2);
            System.out.println("Sublista (índices 0 a 1): " + sublista);
        } else {
            System.out.println("Lista muito pequena para criar sublista");
        }
        System.out.println();
        
        System.out.println("13. Compare Two ArrayLists:");
        boolean iguais = cores.equals(copia);
        System.out.println("As listas são iguais: " + iguais);
        System.out.println();
        
        System.out.println("14. Swap ArrayList Elements:");
        if (cores.size() >= 2) {
            Collections.swap(cores, 0, 1);
            System.out.println("Após trocar elementos nas posições 0 e 1: " + cores);
        } else {
            System.out.println("Lista muito pequena para trocar elementos");
        }
        System.out.println();
        
        System.out.println("15. Join Two ArrayLists:");
        ArrayList<String> segundaLista = new ArrayList<>();
        segundaLista.add("Preto");
        segundaLista.add("Cinza");
        ArrayList<String> listaUnida = new ArrayList<>(cores);
        listaUnida.addAll(segundaLista);
        System.out.println("Lista unida: " + listaUnida);
        System.out.println();
        
        System.out.println("16. Clone ArrayList:");
        ArrayList<String> clone = (ArrayList<String>) cores.clone();
        System.out.println("Clone da lista: " + clone);
        System.out.println();
        
        System.out.println("17. Clear ArrayList:");
        cores.clear();
        System.out.println("Lista após limpeza: " + cores);
        System.out.println();
        
        System.out.println("18. Check if ArrayList is Empty:");
        boolean vazia = cores.isEmpty();
        System.out.println("Lista está vazia: " + vazia);
        System.out.println();
        
        System.out.println("19. Trim ArrayList Capacity:");
        cores.add("Teste");
        cores.trimToSize();
        System.out.println("Lista após trimToSize: " + cores);
        System.out.println();
        
        System.out.println("20. Increase ArrayList Capacity:");
        cores.ensureCapacity(10);
        System.out.println("Capacidade aumentada para pelo menos 10");
        System.out.println();
        
        System.out.println("21. Replace Second Element:");
        cores.add("Primeiro");
        cores.add("Segundo");
        cores.add("Terceiro");
        if (cores.size() > 1) {
            cores.set(1, "Novo Segundo");
            System.out.println("Lista após substituir segundo elemento: " + cores);
        } else {
            System.out.println("Não há segundo elemento para substituir");
        }
        System.out.println();
        
        System.out.println("22. Print Elements by Position:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
        
        System.out.println("\n=== Todas as operações concluídas ===");
    }
}
