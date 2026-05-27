import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetApp {

    public static void main(String[] args) {

        HashSet<String> cores = new HashSet<>();

        System.out.println("1. Append Element to HashSet");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);

        System.out.println("\n2. Iterate HashSet Elements");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("\n3. Get HashSet Size");
        System.out.println(cores.size());

        System.out.println("\n4. Clear HashSet");
        HashSet<String> temp = new HashSet<>(cores);
        temp.clear();
        System.out.println(temp);

        System.out.println("\n5. Check if HashSet is Empty");
        System.out.println(temp.isEmpty());

        System.out.println("\n6. Clone HashSet");
        HashSet<String> clone = (HashSet<String>) cores.clone();
        System.out.println(clone);

        System.out.println("\n7. Convert HashSet to Array");
        String[] array = cores.toArray(new String[0]);
        System.out.println(Arrays.toString(array));

        System.out.println("\n8. Convert HashSet to TreeSet");
        TreeSet<String> tree = new TreeSet<>(cores);
        System.out.println(tree);

        System.out.println("\n9. Find Elements Less Than 7");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(3);
        numeros.add(7);
        numeros.add(9);
        System.out.println(numeros.headSet(7));

        System.out.println("\n10. Compare Two HashSets");
        HashSet<String> outro = new HashSet<>(cores);
        System.out.println(cores.equals(outro));

        System.out.println("\n11. Retain Common Elements");
        outro.add("Preto");
        outro.retainAll(cores);
        System.out.println(outro);

        System.out.println("\n12. Remove All from HashSet");
        cores.removeAll(cores);
        System.out.println(cores);
    }
}
