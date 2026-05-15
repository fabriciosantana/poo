// LinkedListApp.java
import java.util.*;

public class LinkedListApp {
    public static void main(String[] args) {

        LinkedList<String> cores = new LinkedList<>();

        // 1
        System.out.println("1. Append Element");
        cores.add("Azul");
        cores.add("Verde");
        cores.add("Branco");
        System.out.println(cores);

        // 2
        System.out.println("\n2. Iterate LinkedList Elements");
        for (String cor : cores) {
            System.out.println(cor);
        }

        // 3
        System.out.println("\n3. Iterate from Position");
        ListIterator<String> it = cores.listIterator(1);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 4
        System.out.println("\n4. Iterate in Reverse Order");
        Iterator<String> rev = cores.descendingIterator();
        while (rev.hasNext()) {
            System.out.println(rev.next());
        }

        // 5
        System.out.println("\n5. Insert at Position");
        cores.add(1, "Amarelo");
        System.out.println(cores);

        // 6
        System.out.println("\n6. Insert First and Last");
        cores.addFirst("Preto");
        cores.addLast("Roxo");
        System.out.println(cores);

        // 7
        System.out.println("\n7. Insert at Front");
        cores.offerFirst("Cinza");
        System.out.println(cores);

        // 8
        System.out.println("\n8. Insert at End");
        cores.offerLast("Laranja");
        System.out.println(cores);

        // 9
        System.out.println("\n9. Insert Multiple at Position");
        LinkedList<String> extras = new LinkedList<>();
        extras.add("Prata");
        extras.add("Dourado");

        cores.addAll(2, extras);
        System.out.println(cores);

        // 10
        System.out.println("\n10. First and Last Occurrence");
        System.out.println(cores.indexOf("Azul"));
        System.out.println(cores.lastIndexOf("Azul"));

        // 11
        System.out.println("\n11. Print Elements with Positions");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }

        // 12
        System.out.println("\n12. Remove Element");
        cores.remove("Verde");
        System.out.println(cores);

        // 13
        System.out.println("\n13. Remove First and Last");
        cores.removeFirst();
        cores.removeLast();
        System.out.println(cores);

        // 14
        System.out.println("\n14. Clear LinkedList");
        LinkedList<String> temp = new LinkedList<>(cores);
        temp.clear();
        System.out.println(temp);

        // 15
        System.out.println("\n15. Swap Elements");
        Collections.swap(cores, 0, 1);
        System.out.println(cores);

        // 16
        System.out.println("\n16. Shuffle LinkedList");
        Collections.shuffle(cores);
        System.out.println(cores);

        // 17
        System.out.println("\n17. Join LinkedLists");
        LinkedList<String> outra = new LinkedList<>();
        outra.add("Branco");
        outra.add("Verde");

        LinkedList<String> junta = new LinkedList<>(cores);
        junta.addAll(outra);
        System.out.println(junta);

        // 18
        System.out.println("\n18. Copy LinkedList");
        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println(copia);

        // 19
        System.out.println("\n19. Poll First Element");
        System.out.println(cores.pollFirst());
        System.out.println(cores);

        // 20
        System.out.println("\n20. Peek First Element");
        System.out.println(cores.peekFirst());

        // 21
        System.out.println("\n21. Peek Last Element");
        System.out.println(cores.peekLast());

        // 22
        System.out.println("\n22. Contains Element");
        System.out.println(cores.contains("Azul"));

        // 23
        System.out.println("\n23. Convert to ArrayList");
        ArrayList<String> array = new ArrayList<>(cores);
        System.out.println(array);

        // 24
        System.out.println("\n24. Compare LinkedLists");
        System.out.println(cores.equals(copia));

        // 25
        System.out.println("\n25. Check if Empty");
        System.out.println(cores.isEmpty());

        // 26
        System.out.println("\n26. Replace Element");
        if (cores.size() > 1) {
            cores.set(1, "Turquesa");
        }
        System.out.println(cores);
    }
}