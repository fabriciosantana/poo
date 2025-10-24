import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HashSetApp {

    public static void main(String[] args) {
        HashSet<String> cores = new HashSet<>();

        System.out.println("1. Append Element to HashSet");
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Verde");
        cores.add("Amarelo");
        System.out.println("HashSet (ordem não garantida): " + cores);
        System.out.println("--------------------");

        System.out.println("2. Iterate HashSet Elements");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println("--------------------");

        System.out.println("3. Get HashSet Size");
        System.out.println("Tamanho (ignorou duplicado): " + cores.size());
        System.out.println("--------------------");

        System.out.println("4. Clear HashSet");
        HashSet<String> tempClear = new HashSet<>(cores);
        System.out.println("Conjunto 'tempClear' antes: " + tempClear);
        tempClear.clear();
        System.out.println("Conjunto 'tempClear' depois: " + tempClear);
        System.out.println("Conjunto 'cores' original: " + cores);
        System.out.println("--------------------");

        System.out.println("5. Check if HashSet is Empty");
        System.out.println("O conjunto 'cores' está vazio? " + cores.isEmpty());
        System.out.println("O conjunto 'tempClear' está vazio? " + tempClear.isEmpty());
        System.out.println("--------------------");

        System.out.println("6. Clone HashSet");
        HashSet<String> clone = (HashSet<String>) cores.clone();
        System.out.println("Original: " + cores);
        System.out.println("Clone: " + clone);
        System.out.println("--------------------");

        System.out.println("7. Convert HashSet to Array");
        String[] arrayCores = new String[cores.size()];
        cores.toArray(arrayCores);
        System.out.println("Elementos do Array (ordem pode variar):");
        for (String cor : arrayCores) {
            System.out.println(cor);
        }
        System.out.println("--------------------");

        System.out.println("8. Convert HashSet to TreeSet");
        TreeSet<String> treeSetCores = new TreeSet<>(cores);
        System.out.println("HashSet (desordenado): " + cores);
        System.out.println("TreeSet (ordenado): " + treeSetCores);
        System.out.println("--------------------");

        System.out.println("9. Find Elements Less Than 7 (em um TreeSet)");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(8);
        numeros.add(3);
        numeros.add(10);
        System.out.println("TreeSet de números: " + numeros);
        Set<Integer> menoresQue7 = numeros.headSet(7);
        System.out.println("Elementos menores que 7: " + menoresQue7);
        System.out.println("--------------------");

        System.out.println("10. Compare Two HashSets");
        HashSet<String> A = new HashSet<>(cores);
        HashSet<String> B = new HashSet<>(cores);
        System.out.println("Set A: " + A);
        System.out.println("Set B: " + B);
        System.out.println("A e B são iguais? " + A.equals(B));
        B.add("Preto");
        System.out.println("Set B modificado: " + B);
        System.out.println("A e B são iguais? " + A.equals(B));
        System.out.println("--------------------");

        System.out.println("11. Retain Common Elements (Interseção)");
        HashSet<String> retainSet = new HashSet<>(cores);
        HashSet<String> outros = new HashSet<>();
        outros.add("Verde");
        outros.add("Azul");
        outros.add("Preto");

        System.out.println("Set Original: " + retainSet);
        System.out.println("Set 'Outros': " + outros);
        retainSet.retainAll(outros);
        System.out.println("Set após retainAll (interseção): " + retainSet);
        System.out.println("--------------------");

        System.out.println("12. Remove All from HashSet (Diferença)");
        HashSet<String> diffSet = new HashSet<>(cores);
        HashSet<String> aRemover = new HashSet<>();
        aRemover.add("Vermelho");
        aRemover.add("Amarelo");
        aRemover.add("Inexistente");

        System.out.println("Set Original: " + diffSet);
        System.out.println("Set 'A Remover': " + aRemover);
        diffSet.removeAll(aRemover);
        System.out.println("Set após removeAll (diferença): " + diffSet);
        System.out.println("--------------------");
    }
}
