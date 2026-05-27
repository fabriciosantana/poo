import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<String> cores = new LinkedList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");

        cores.add("Preto");
        System.out.println("1 Append Element: " + cores);

        System.out.println("2 Iterate LinkedList Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("3 Iterate from Position:");
        ListIterator<String> it = cores.listIterator(2);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("4 Iterate in Reverse Order:");
        ListIterator<String> rev = cores.listIterator(cores.size());
        while (rev.hasPrevious()) {
            System.out.println(rev.previous());
        }

        cores.add(2, "Laranja");
        System.out.println("5 Insert at Position: " + cores);

        cores.addFirst("Cinza");
        cores.addLast("Roxo");
        System.out.println("6 Insert First and Last: " + cores);

        cores.addFirst("Violeta");
        System.out.println("7 Insert at Front: " + cores);

        cores.addLast("Marrom");
        System.out.println("8 Insert at End: " + cores);

        cores.addAll(3, List.of("Turquesa", "Magenta"));
        System.out.println("9 Insert Multiple at Position: " + cores);

        String alvo = "Azul";
        System.out.println("10 First and Last Occurrence: " + cores.indexOf(alvo) + ", " + cores.lastIndexOf(alvo));

        System.out.println("11 Print Elements with Positions:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }

        cores.remove("Branco");
        System.out.println("12 Remove Element: " + cores);

        cores.removeFirst();
        cores.removeLast();
        System.out.println("13 Remove First and Last: " + cores);

        if (cores.size() > 3) {
            Collections.swap(cores, 1, 3);
        }
        System.out.println("15 Swap Elements: " + cores);

        Collections.shuffle(cores);
        System.out.println("16 Shuffle LinkedList: " + cores);

        LinkedList<String> outra = new LinkedList<>();
        outra.add("Dourado");
        outra.add("Prata");
        LinkedList<String> uniao = new LinkedList<>(cores);
        uniao.addAll(outra);
        System.out.println("17 Join LinkedLists: " + uniao);

        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println("18 Copy LinkedList: " + copia);

        String pollPrimeiro = copia.pollFirst();
        System.out.println("19 Poll First Element: " + pollPrimeiro);

        String peekPrimeiro = copia.peekFirst();
        System.out.println("20 Peek First Element: " + peekPrimeiro);

        String peekUltimo = copia.peekLast();
        System.out.println("21 Peek Last Element: " + peekUltimo);

        boolean contem = cores.contains("Verde");
        System.out.println("22 Contains Element: " + contem);

        ArrayList<String> arrayList = new ArrayList<>(cores);
        System.out.println("23 Convert to ArrayList: " + arrayList);

        boolean iguais = cores.equals(new LinkedList<>(cores));
        System.out.println("24 Compare LinkedLists: " + iguais);

        boolean vazia = cores.isEmpty();
        System.out.println("25 Check if Empty: " + vazia);

        if (cores.size() > 1) {
            cores.set(1, "Azul Escuro");
        }
        System.out.println("26 Replace Element: " + cores);

        cores.clear();
        System.out.println("14 Clear LinkedList: " + cores);
    }
}

