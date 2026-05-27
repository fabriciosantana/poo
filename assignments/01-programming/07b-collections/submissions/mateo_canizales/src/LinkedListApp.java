import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedListApp {

    public static void main(String[] args) {

        LinkedList<String> cores = new LinkedList<>();
        
        System.out.println("1. Append Element");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);

        System.out.println("\n2. Iterate LinkedList Elements");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("\n3. Iterate from Position");
        for (int i = 1; i < cores.size(); i++) {
            System.out.println(cores.get(i));
        }

        System.out.println("\n4. Iterate in Reverse Order");
        for (int i = cores.size() - 1; i >= 0; i--) {
            System.out.println(cores.get(i));
        }

        System.out.println("\n5. Insert at Position");
        cores.add(1, "Amarelo");
        System.out.println(cores);

        System.out.println("\n6. Insert First and Last");
        cores.addFirst("Preto");
        cores.addLast("Rosa");
        System.out.println(cores);

        System.out.println("\n7. Insert at Front");
        cores.offerFirst("Cinza");
        System.out.println(cores);

        System.out.println("\n8. Insert at End");
        cores.offerLast("Laranja");
        System.out.println(cores);

        System.out.println("\n9. Insert Multiple at Position");
        LinkedList<String> extras = new LinkedList<>();
        extras.add("Marrom");
        extras.add("Roxo");
        cores.addAll(2, extras);
        System.out.println(cores);

        System.out.println("\n10. First and Last Occurrence");
        System.out.println(cores.indexOf("Azul"));
        System.out.println(cores.lastIndexOf("Azul"));

        System.out.println("\n11. Print Elements with Positions");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }

        System.out.println("\n12. Remove Element");
        cores.remove("Roxo");
        System.out.println(cores);

        System.out.println("\n13. Remove First and Last");
        cores.removeFirst();
        cores.removeLast();
        System.out.println(cores);

        System.out.println("\n14. Clear LinkedList");
        LinkedList<String> temp = new LinkedList<>(cores);
        temp.clear();
        System.out.println(temp);

        System.out.println("\n15. Swap Elements");
        Collections.swap(cores, 0, 1);
        System.out.println(cores);

        System.out.println("\n16. Shuffle LinkedList");
        Collections.shuffle(cores);
        System.out.println(cores);

        System.out.println("\n17. Join LinkedLists");
        LinkedList<String> outra = new LinkedList<>();
        outra.add("Dourado");

        LinkedList<String> unida = new LinkedList<>(cores);
        unida.addAll(outra);
        System.out.println(unida);

        System.out.println("\n18. Copy LinkedList");
        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println(copia);

        System.out.println("\n19. Poll First Element");
        System.out.println(cores.pollFirst());

        System.out.println("\n20. Peek First Element");
        System.out.println(cores.peekFirst());

        System.out.println("\n21. Peek Last Element");
        System.out.println(cores.peekLast());

        System.out.println("\n22. Contains Element");
        System.out.println(cores.contains("Azul"));

        System.out.println("\n23. Convert to ArrayList");
        ArrayList<String> array = new ArrayList<>(cores);
        System.out.println(array);

        System.out.println("\n24. Compare LinkedLists");
        System.out.println(cores.equals(copia));

        System.out.println("\n25. Check if Empty");
        System.out.println(cores.isEmpty());

        System.out.println("\n26. Replace Element");
        if (cores.size() > 0) {
            cores.set(0, "Prata");
        }
        System.out.println(cores);
    }
}