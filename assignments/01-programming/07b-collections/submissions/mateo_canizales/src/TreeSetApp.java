import java.util.TreeSet;

public class TreeSetApp {

    public static void main(String[] args) {

        TreeSet<Integer> numeros = new TreeSet<>();

        System.out.println("1. Create and Print TreeSet");
        numeros.add(10);
        numeros.add(2);
        numeros.add(7);
        numeros.add(5);
        System.out.println(numeros);

        System.out.println("\n2. Iterate TreeSet Elements");
        for (Integer n : numeros) {
            System.out.println(n);
        }

        System.out.println("\n3. Add Elements to Another TreeSet");
        TreeSet<Integer> outro = new TreeSet<>();
        outro.addAll(numeros);
        System.out.println(outro);

        System.out.println("\n4. Reverse Order TreeSet");
        System.out.println(numeros.descendingSet());

        System.out.println("\n5. Get First and Last Elements");
        System.out.println("Primeiro: " + numeros.first());
        System.out.println("Último: " + numeros.last());

        System.out.println("\n6. Clone TreeSet");
        TreeSet<Integer> clone = (TreeSet<Integer>) numeros.clone();
        System.out.println(clone);

        System.out.println("\n7. TreeSet Size");
        System.out.println(numeros.size());

        System.out.println("\n8. Compare TreeSets");
        System.out.println(numeros.equals(outro));

        System.out.println("\n9. Elements Less Than 7");
        System.out.println(numeros.headSet(7));

        System.out.println("\n10. Ceiling Element");
        System.out.println(numeros.ceiling(6));

        System.out.println("\n11. Floor Element");
        System.out.println(numeros.floor(6));

        System.out.println("\n12. Higher Element");
        System.out.println(numeros.higher(5));

        System.out.println("\n13. Lower Element");
        System.out.println(numeros.lower(5));

        System.out.println("\n14. Poll First Element");
        System.out.println(numeros.pollFirst());
        System.out.println(numeros);

        System.out.println("\n15. Poll Last Element");
        System.out.println(numeros.pollLast());
        System.out.println(numeros);

        System.out.println("\n16. Remove Element");
        numeros.remove(5);
        System.out.println(numeros);
    }
}
