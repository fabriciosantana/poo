import java.util.*;

public class LinkedListApp {
    
    public static void main(String[] args) {
        System.out.println("=== Operações com LinkedList ===\n");
        
        System.out.println("1. Append Element:");
        LinkedList<String> cores = new LinkedList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        System.out.println("Após adicionar elementos: " + cores);
        System.out.println();
        
        System.out.println("2. Iterate LinkedList Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println();
        
        System.out.println("3. Iterate from Position:");
        ListIterator<String> iterator = cores.listIterator(1);
        System.out.println("Elementos a partir da posição 1:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        
        System.out.println("4. Iterate in Reverse Order:");
        ListIterator<String> reverseIterator = cores.listIterator(cores.size());
        System.out.println("Elementos em ordem reversa:");
        while (reverseIterator.hasPrevious()) {
            System.out.println(reverseIterator.previous());
        }
        System.out.println();
        
        System.out.println("5. Insert at Position:");
        cores.add(1, "Rosa");
        System.out.println("Após inserir 'Rosa' na posição 1: " + cores);
        System.out.println();
        
        System.out.println("6. Insert First and Last:");
        cores.addFirst("Primeiro");
        cores.addLast("Último");
        System.out.println("Após inserir primeiro e último: " + cores);
        System.out.println();
        
        System.out.println("7. Insert at Front:");
        cores.addFirst("Front");
        System.out.println("Após inserir no front: " + cores);
        System.out.println();
        
        System.out.println("8. Insert at End:");
        cores.addLast("End");
        System.out.println("Após inserir no end: " + cores);
        System.out.println();
        
        System.out.println("9. Insert Multiple at Position:");
        LinkedList<String> novasCores = new LinkedList<>();
        novasCores.add("Preto");
        novasCores.add("Branco");
        cores.addAll(2, novasCores);
        System.out.println("Após inserir múltiplos elementos na posição 2: " + cores);
        System.out.println();
        
        System.out.println("10. First and Last Occurrence:");
        cores.add("Verde");
        int primeiraOcorrencia = cores.indexOf("Verde");
        int ultimaOcorrencia = cores.lastIndexOf("Verde");
        System.out.println("Primeira ocorrência de 'Verde': " + primeiraOcorrencia);
        System.out.println("Última ocorrência de 'Verde': " + ultimaOcorrencia);
        System.out.println();
        
        System.out.println("11. Print Elements with Positions:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
        System.out.println();
        
        System.out.println("12. Remove Element:");
        boolean removido = cores.remove("Rosa");
        System.out.println("'Rosa' removido: " + removido);
        System.out.println("Lista após remoção: " + cores);
        System.out.println();
        
        System.out.println("13. Remove First and Last:");
        String primeiro = cores.removeFirst();
        String ultimo = cores.removeLast();
        System.out.println("Primeiro removido: " + primeiro);
        System.out.println("Último removido: " + ultimo);
        System.out.println("Lista após remoções: " + cores);
        System.out.println();
        
        System.out.println("14. Clear LinkedList:");
        LinkedList<String> copiaParaLimpar = new LinkedList<>(cores);
        copiaParaLimpar.clear();
        System.out.println("Lista após limpeza: " + copiaParaLimpar);
        System.out.println();
        
        System.out.println("15. Swap Elements:");
        if (cores.size() >= 2) {
            Collections.swap(cores, 0, 1);
            System.out.println("Após trocar elementos nas posições 0 e 1: " + cores);
        }
        System.out.println();
        
        System.out.println("16. Shuffle LinkedList:");
        Collections.shuffle(cores);
        System.out.println("Lista embaralhada: " + cores);
        System.out.println();
        
        System.out.println("17. Join LinkedLists:");
        LinkedList<String> segundaLista = new LinkedList<>();
        segundaLista.add("Cinza");
        segundaLista.add("Marrom");
        LinkedList<String> listaUnida = new LinkedList<>(cores);
        listaUnida.addAll(segundaLista);
        System.out.println("Lista unida: " + listaUnida);
        System.out.println();
        
        System.out.println("18. Copy LinkedList:");
        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println("Cópia da lista: " + copia);
        System.out.println();
        
        System.out.println("19. Poll First Element:");
        String primeiroPoll = cores.pollFirst();
        System.out.println("Primeiro elemento removido: " + primeiroPoll);
        System.out.println("Lista após pollFirst: " + cores);
        System.out.println();
        
        System.out.println("20. Peek First Element:");
        String primeiroPeek = cores.peekFirst();
        System.out.println("Primeiro elemento (sem remover): " + primeiroPeek);
        System.out.println("Lista permanece: " + cores);
        System.out.println();
        
        System.out.println("21. Peek Last Element:");
        String ultimoPeek = cores.peekLast();
        System.out.println("Último elemento (sem remover): " + ultimoPeek);
        System.out.println("Lista permanece: " + cores);
        System.out.println();
        
        System.out.println("22. Contains Element:");
        boolean contem = cores.contains("Azul");
        System.out.println("Lista contém 'Azul': " + contem);
        System.out.println();
        
        System.out.println("23. Convert to ArrayList:");
        ArrayList<String> arrayList = new ArrayList<>(cores);
        System.out.println("Convertido para ArrayList: " + arrayList);
        System.out.println();
        
        System.out.println("24. Compare LinkedLists:");
        boolean iguais = cores.equals(copia);
        System.out.println("As listas são iguais: " + iguais);
        System.out.println();
        
        System.out.println("25. Check if Empty:");
        boolean vazia = cores.isEmpty();
        System.out.println("Lista está vazia: " + vazia);
        System.out.println();
        
        System.out.println("26. Replace Element:");
        if (cores.size() > 0) {
            String elementoAntigo = cores.set(0, "Novo Elemento");
            System.out.println("Elemento substituído: " + elementoAntigo);
            System.out.println("Lista após substituição: " + cores);
        }
        
        System.out.println("\n=== Todas as operações concluídas ===");
    }
}
