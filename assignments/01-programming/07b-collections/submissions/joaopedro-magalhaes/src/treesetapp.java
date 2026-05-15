// TreeSetApp.java
import java.util.*;

public class TreeSetApp {
    public static void main(String[] args) {

        // 1
        System.out.println("1. Create and Print TreeSet");
        TreeSet<String> cores = new TreeSet<>();
        cores.add("Azul");
        cores.add("Verde");
        cores.add("Branco");
        System.out.println(cores);

        // 2
        System.out.println("\n2. Iterate TreeSet Elements");
        for (String cor : cores) {
            System.out.println(cor);
        }

        // 3
        System.out.println("\n3. Add Elements to Another TreeSet");
        TreeSet<String> outro = new TreeSet<>();
        outro.addAll(cores);
        System.out.println(outro);

        // 4
        System.out.println("\n4. Reverse Order TreeSet");
        System.out.println(cores.descendingSet());

        // 5
        System.out.println("\n5. Get First and Last Elements");
        System.out.println(cores.first());
        System.out.println(cores.last());

        // 6
        System.out.println("\n6. Clone TreeSet");
        TreeSet<String> clone = (TreeSet<String>) cores.clone();
        System.out.println(clone);

        // 7
        System.out.println("\n7. TreeSet Size");
        System.out.println(cores.size());

        // 8
        System.out.println("\n8. Compare TreeSets");
        System.out.println(cores.equals(outro));

        // 9
        System.out.println("\n9. Elements Less Than 7");
        TreeSet<Integer> nums = new TreeSet<>();
        nums.add(2);
        nums.add(5);
        nums.add(7);
        nums.add(10);

        System.out.println(nums.headSet(7));

        // 10
        System.out.println("\n10. Ceiling Element");
        System.out.println(nums.ceiling(6));

        // 11
        System.out.println("\n11. Floor Element");
        System.out.println(nums.floor(6));

        // 12
        System.out.println("\n12. Higher Element");
        System.out.println(nums.higher(7));

        // 13
        System.out.println("\n13. Lower Element");
        System.out.println(nums.lower(7));

        // 14
        System.out.println("\n14. Poll First Element");
        System.out.println(nums.pollFirst());
        System.out.println(nums);

        // 15
        System.out.println("\n15. Poll Last Element");
        System.out.println(nums.pollLast());
        System.out.println(nums);

        // 16
        System.out.println("\n16. Remove Element");
        cores.remove("Azul");
        System.out.println(cores);
    }
}