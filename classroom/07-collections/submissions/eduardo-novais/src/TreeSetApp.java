import java.util.*;

public class TreeSetApp {
    
    public static void main(String[] args) {
        System.out.println("=== Operações com TreeSet ===\n");
        
        System.out.println("1. Create and Print TreeSet:");
        TreeSet<String> cores = new TreeSet<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        cores.add("Rosa");
        System.out.println("TreeSet criado: " + cores);
        System.out.println();
        
        System.out.println("2. Iterate TreeSet Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println();
        
        System.out.println("3. Add Elements to Another TreeSet:");
        TreeSet<String> outroTreeSet = new TreeSet<>();
        outroTreeSet.addAll(cores);
        outroTreeSet.add("Preto");
        outroTreeSet.add("Cinza");
        System.out.println("Novo TreeSet: " + outroTreeSet);
        System.out.println();
        
        System.out.println("4. Reverse Order TreeSet:");
        TreeSet<String> reverso = new TreeSet<>(Collections.reverseOrder());
        reverso.addAll(cores);
        System.out.println("TreeSet em ordem reversa: " + reverso);
        System.out.println();
        
        System.out.println("5. Get First and Last Elements:");
        String primeiro = cores.first();
        String ultimo = cores.last();
        System.out.println("Primeiro elemento: " + primeiro);
        System.out.println("Último elemento: " + ultimo);
        System.out.println();
        
        System.out.println("6. Clone TreeSet:");
        TreeSet<String> clone = (TreeSet<String>) cores.clone();
        System.out.println("Clone do TreeSet: " + clone);
        System.out.println();
        
        System.out.println("7. TreeSet Size:");
        int tamanho = cores.size();
        System.out.println("Tamanho do TreeSet: " + tamanho);
        System.out.println();
        
        System.out.println("8. Compare TreeSets:");
        boolean iguais = cores.equals(clone);
        System.out.println("Os TreeSets são iguais: " + iguais);
        System.out.println();
        
        System.out.println("9. Elements Less Than 7:");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(3);
        numeros.add(7);
        numeros.add(1);
        numeros.add(9);
        numeros.add(5);
        numeros.add(2);
        System.out.println("TreeSet de números: " + numeros);
        TreeSet<Integer> menoresQue7 = new TreeSet<>(numeros.headSet(7));
        System.out.println("Elementos menores que 7: " + menoresQue7);
        System.out.println();
        
        System.out.println("10. Ceiling Element:");
        String ceiling = cores.ceiling("C");
        System.out.println("Elemento maior ou igual a 'C': " + ceiling);
        System.out.println();
        
        System.out.println("11. Floor Element:");
        String floor = cores.floor("M");
        System.out.println("Elemento menor ou igual a 'M': " + floor);
        System.out.println();
        
        System.out.println("12. Higher Element:");
        String higher = cores.higher("A");
        System.out.println("Elemento estritamente maior que 'A': " + higher);
        System.out.println();
        
        System.out.println("13. Lower Element:");
        String lower = cores.lower("Z");
        System.out.println("Elemento estritamente menor que 'Z': " + lower);
        System.out.println();
        
        System.out.println("14. Poll First Element:");
        String primeiroPoll = cores.pollFirst();
        System.out.println("Primeiro elemento removido: " + primeiroPoll);
        System.out.println("TreeSet após pollFirst: " + cores);
        System.out.println();
        
        System.out.println("15. Poll Last Element:");
        String ultimoPoll = cores.pollLast();
        System.out.println("Último elemento removido: " + ultimoPoll);
        System.out.println("TreeSet após pollLast: " + cores);
        System.out.println();
        
        System.out.println("16. Remove Element:");
        boolean removido = cores.remove("Azul");
        System.out.println("'Azul' removido: " + removido);
        System.out.println("TreeSet após remoção: " + cores);
        
        System.out.println("\n=== Todas as operações concluídas ===");
    }
}
