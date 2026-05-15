// ArrayListApp.java
import java.util.*;

public class ArrayListApp {
    public static void main(String[] args) {

        // 1
        System.out.println("1. Create and Print ArrayList");
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);

        // 2
        System.out.println("\n2. Iterate ArrayList Elements");
        for (String cor : cores) {
            System.out.println(cor);
        }

        // 3
        System.out.println("\n3. Insert at First Position");
        cores.add(0, "Preto");
        System.out.println(cores);

        // 4
        System.out.println("\n4. Retrieve Element by Index");
        if (cores.size() > 2) {
            System.out.println(cores.get(2));
        }

        // 5
        System.out.println("\n5. Update ArrayList Element");
        cores.set(1, "Roxo");
        System.out.println(cores);

        // 6
        System.out.println("\n6. Remove Third Element");
        if (cores.size() > 2) {
            cores.remove(2);
        }
        System.out.println(cores);

        // 7
        System.out.println("\n7. Search Element in ArrayList");
        System.out.println(cores.contains("Azul"));

        // 8
        System.out.println("\n8. Sort ArrayList");
        Collections.sort(cores);
        System.out.println(cores);

        // 9
        System.out.println("\n9. Copy ArrayList");
        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println(copia);

        // 10
        System.out.println("\n10. Shuffle ArrayList");
        Collections.shuffle(cores);
        System.out.println(cores);

        // 11
        System.out.println("\n11. Reverse ArrayList");
        Collections.reverse(cores);
        System.out.println(cores);

        // 12
        System.out.println("\n12. Extract Sublist from ArrayList");
        if (cores.size() >= 2) {
            System.out.println(cores.subList(0, 2));
        }

        // 13
        System.out.println("\n13. Compare Two ArrayLists");
        System.out.println(cores.equals(copia));

        // 14
        System.out.println("\n14. Swap ArrayList Elements");
        if (cores.size() >= 2) {
            Collections.swap(cores, 0, 1);
        }
        System.out.println(cores);

        // 15
        System.out.println("\n15. Join Two ArrayLists");
        ArrayList<String> lista2 = new ArrayList<>();
        lista2.add("Cinza");
        lista2.add("Laranja");

        ArrayList<String> unida = new ArrayList<>(cores);
        unida.addAll(lista2);
        System.out.println(unida);

        // 16
        System.out.println("\n16. Clone ArrayList");
        ArrayList<String> clone = (ArrayList<String>) cores.clone();
        System.out.println(clone);

        // 17
        System.out.println("\n17. Clear ArrayList");
        clone.clear();
        System.out.println(clone);

        // 18
        System.out.println("\n18. Check if ArrayList is Empty");
        System.out.println(clone.isEmpty());

        // 19
        System.out.println("\n19. Trim ArrayList Capacity");
        cores.trimToSize();
        System.out.println("trimToSize executado");

        // 20
        System.out.println("\n20. Increase ArrayList Capacity");
        cores.ensureCapacity(20);
        System.out.println("ensureCapacity executado");

        // 21
        System.out.println("\n21. Replace Second Element");
        if (cores.size() > 1) {
            cores.set(1, "Marrom");
        }
        System.out.println(cores);

        // 22
        System.out.println("\n22. Print Elements by Position");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
    }
}