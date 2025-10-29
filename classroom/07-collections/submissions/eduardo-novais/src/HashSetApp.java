import java.util.*;

public class HashSetApp {
    
    public static void main(String[] args) {
        System.out.println("=== Operações com HashSet ===\n");
        
        System.out.println("1. Append Element to HashSet:");
        HashSet<String> cores = new HashSet<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println("Após adicionar elementos: " + cores);
        System.out.println();
        
        System.out.println("2. Iterate HashSet Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println();
        
        System.out.println("3. Get HashSet Size:");
        int tamanho = cores.size();
        System.out.println("Tamanho do HashSet: " + tamanho);
        System.out.println();
        
        System.out.println("4. Clear HashSet:");
        HashSet<String> copiaParaLimpar = new HashSet<>(cores);
        copiaParaLimpar.clear();
        System.out.println("HashSet após limpeza: " + copiaParaLimpar);
        System.out.println();
        
        System.out.println("5. Check if HashSet is Empty:");
        boolean vazio = cores.isEmpty();
        System.out.println("HashSet está vazio: " + vazio);
        System.out.println();
        
        System.out.println("6. Clone HashSet:");
        HashSet<String> clone = (HashSet<String>) cores.clone();
        System.out.println("Clone do HashSet: " + clone);
        System.out.println();
        
        System.out.println("7. Convert HashSet to Array:");
        String[] array = cores.toArray(new String[0]);
        System.out.println("Array convertido: " + Arrays.toString(array));
        System.out.println();
        
        System.out.println("8. Convert HashSet to TreeSet:");
        TreeSet<String> treeSet = new TreeSet<>(cores);
        System.out.println("TreeSet convertido: " + treeSet);
        System.out.println();
        
        System.out.println("9. Find Elements Less Than 7:");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(3);
        numeros.add(7);
        numeros.add(1);
        numeros.add(9);
        numeros.add(5);
        System.out.println("TreeSet de números: " + numeros);
        TreeSet<Integer> menoresQue7 = new TreeSet<>(numeros.headSet(7));
        System.out.println("Elementos menores que 7: " + menoresQue7);
        System.out.println();
        
        System.out.println("10. Compare Two HashSets:");
        HashSet<String> segundoHashSet = new HashSet<>();
        segundoHashSet.add("Verde");
        segundoHashSet.add("Amarelo");
        segundoHashSet.add("Azul");
        segundoHashSet.add("Branco");
        boolean iguais = cores.equals(segundoHashSet);
        System.out.println("Os HashSets são iguais: " + iguais);
        System.out.println();
        
        System.out.println("11. Retain Common Elements:");
        HashSet<String> outroHashSet = new HashSet<>();
        outroHashSet.add("Verde");
        outroHashSet.add("Rosa");
        outroHashSet.add("Azul");
        outroHashSet.add("Preto");
        System.out.println("Outro HashSet: " + outroHashSet);
        cores.retainAll(outroHashSet);
        System.out.println("Após manter apenas elementos comuns: " + cores);
        System.out.println();
        
        System.out.println("12. Remove All from HashSet:");
        HashSet<String> copiaParaRemover = new HashSet<>(cores);
        copiaParaRemover.removeAll(copiaParaRemover);
        System.out.println("Após remover todos os elementos: " + copiaParaRemover);
        
        System.out.println("\n=== Todas as operações concluídas ===");
    }
}
