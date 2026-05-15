// HashSetApp.java
import java.util.*;

public class HashSetApp {
    public static void main(String[] args) {

        HashSet<String> cores = new HashSet<>();

        // 1
        System.out.println("1. Append Element to HashSet");
        cores.add("Azul");
        cores.add("Verde");
        cores.add("Branco");
        System.out.println(cores);

        // 2
        System.out.println("\n2. Iterate HashSet Elements");
        for (String cor : cores) {
            System.out.println(cor);
        }

        // 3
        System.out.println("\n3. Get HashSet Size");
        System.out.println(cores.size());

        // 4
        System.out.println("\n4. Clear HashSet");
        HashSet<String> temp = new HashSet<>(cores);
        temp.clear();
        System.out.println(temp);

        // 5
        System.out.println("\n5. Check if HashSet is Empty");
        System.out.println(temp.isEmpty());

        // 6
        System.out.println("\n6. Clone HashSet");
        HashSet<String> clone = (HashSet<String>) cores.clone();
        System.out.println(clone);

        // 7
        System.out.println("\n7. Convert HashSet to Array");
        String[] array = cores.toArray(new String[0]);
        System.out.println(Arrays.toString(array));

        // 8
        System.out.println("\n8. Convert HashSet to TreeSet");
        TreeSet<String> tree = new TreeSet<>(cores);
        System.out.println(tree);

        // 9
        System.out.println("\n9. Find Elements Less Than 7");
        TreeSet<Integer> nums = new TreeSet<>();
        nums.add(2);
        nums.add(5);
        nums.add(7);
        nums.add(9);

        System.out.println(nums.headSet(7));

        // 10
        System.out.println("\n10. Compare Two HashSets");
        HashSet<String> outro = new HashSet<>(cores);
        System.out.println(cores.equals(outro));

        // 11
        System.out.println("\n11. Retain Common Elements");
        outro.add("Preto");
        cores.retainAll(outro);
        System.out.println(cores);

        // 12
        System.out.println("\n12. Remove All from HashSet");
        cores.removeAll(cores);
        System.out.println(cores);
    }
}