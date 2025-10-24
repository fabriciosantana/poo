import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {

    public static void main(String[] args) {

        LinkedList<String> cores = new LinkedList<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        System.out.println("Lista inicial: " + cores);
        System.out.println("--------------------");

        System.out.println("1. Append Element");
        cores.add("Amarelo");
        System.out.println(cores);
        System.out.println("--------------------");

        System.out.println("2. Iterate LinkedList Elements");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println("--------------------");

        System.out.println("3. Iterate from Position (Index 1)");
        int startIdx = 1;
        Iterator<String> it = cores.listIterator(startIdx);
        System.out.println("Iterando a partir do índice " + startIdx + ":");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("--------------------");

        System.out.println("4. Iterate in Reverse Order");
        Iterator<String> reverseIt = cores.descendingIterator();
        System.out.println("Iterando em ordem reversa:");
        while (reverseIt.hasNext()) {
            System.out.println(reverseIt.next());
        }
        System.out.println("--------------------");

        System.out.println("5. Insert at Position (Index 2)");
        cores.add(2, "Laranja");
        System.out.println(cores);
        System.out.println("--------------------");

        System.out.println("6. Insert First and Last");
        cores.addFirst("Preto");
        cores.addLast("Branco");
        System.out.println(cores);
        System.out.println("--------------------");

        System.out.println("7. Insert at Front");
        cores.offerFirst("Cinza");
        System.out.println(cores);
        System.out.println("--------------------");

        System.out.println("8. Insert at End");
        cores.offerLast("Roxo");
        System.out.println(cores);
        System.out.println("--------------------");

        System.out.println("9. Insert Multiple at Position (Index 1)");
        List<String> novos = new ArrayList<>();
        novos.add("Marrom");
        novos.add("Rosa");
        cores.addAll(1, novos);
        System.out.println(cores);
        System.out.println("--------------------");

        System.out.println("10. First and Last Occurrence (Element 'Verde')");
        cores.add("Verde");
        System.out.println("Lista atual (com 'Verde' duplicado): " + cores);
        int firstIdx = cores.indexOf("Verde");
        int lastIdx = cores.lastIndexOf("Verde");
        System.out.println("Primeira ocorrência 'Verde': " + firstIdx);
        System.out.println("Última ocorrência 'Verde': " + lastIdx);
        System.out.println("--------------------");

        System.out.println("11. Print Elements with Positions");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
        System.out.println("--------------------");

        System.out.println("12. Remove Element ('Laranja')");
        cores.remove("Laranja");
        System.out.println(cores);
        System.out.println("--------------------");

        System.out.println("13. Remove First and Last");
        String first = cores.removeFirst();
        String last = cores.removeLast();
        System.out.println("Removido primeiro: " + first);
        System.out.println("Removido último: " + last);
        System.out.println(cores);
        System.out.println("--------------------");

        System.out.println("14. Clear LinkedList");
        LinkedList<String> tempClear = new LinkedList<>(cores);
        System.out.println("Lista 'tempClear' antes: " + tempClear);
        tempClear.clear();
        System.out.println("Lista 'tempClear' depois: " + tempClear);
        System.out.println("Lista 'cores' original (não afetada): " + cores);
        System.out.println("--------------------");

        System.out.println("15. Swap Elements (Index 1 e 3)");
        Collections.swap(cores, 1, 3);
        System.out.println(cores);
        System.out.println("--------------------");

        System.out.println("16. Shuffle LinkedList");
        Collections.shuffle(cores);
        System.out.println(cores);
        System.out.println("--------------------");

        System.out.println("17. Join LinkedLists");
        LinkedList<String> lista2 = new LinkedList<>();
        lista2.add("Dourado");
        lista2.add("Prata");
        LinkedList<String> uniao = new LinkedList<>(cores);
        uniao.addAll(lista2);
        System.out.println("Lista 1: " + cores);
        System.out.println("Lista 2: " + lista2);
        System.out.println("União: " + uniao);
        System.out.println("--------------------");

        System.out.println("18. Copy LinkedList");
        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println("Original: " + cores);
        System.out.println("Cópia: " + copia);
        System.out.println("--------------------");

        System.out.println("19. Poll First Element");
        System.out.println("Lista antes: " + cores);
        String polled = cores.pollFirst();
        System.out.println("Elemento removido (poll): " + polled);
        System.out.println("Lista depois: " + cores);
        System.out.println("--------------------");

        System.out.println("20. Peek First Element");
        String peeked = cores.peekFirst();
        System.out.println("Elemento recuperado (peek): " + peeked);
        System.out.println("Lista (não alterada): " + cores);
        System.out.println("--------------------");

        System.out.println("21. Peek Last Element");
        String peekedLast = cores.peekLast();
        System.out.println("Elemento recuperado (peekLast): " + peekedLast);
        System.out.println("Lista (não alterada): " + cores);
        System.out.println("--------------------");

        System.out.println("22. Contains Element ('Azul')");
        boolean contem = cores.contains("Azul");
        System.out.println("Contém 'Azul'? " + contem);
        System.out.println("--------------------");

        System.out.println("23. Convert to ArrayList");
        List<String> arrayListConvertida = new ArrayList<>(cores);
        System.out.println("LinkedList: " + cores);
        System.out.println("ArrayList: " + arrayListConvertida);
        System.out.println("--------------------");

        System.out.println("24. Compare LinkedLists");
        LinkedList<String> A = new LinkedList<>(cores);
        LinkedList<String> B = new LinkedList<>(cores);
        System.out.println("Lista A: " + A);
        System.out.println("Lista B: " + B);
        System.out.println("A e B são iguais? " + A.equals(B));
        B.add("Extra");
        System.out.println("Lista B modificada: " + B);
        System.out.println("A e B são iguais? " + A.equals(B));
        System.out.println("--------------------");

        System.out.println("25. Check if Empty");
        System.out.println("A lista 'cores' está vazia? " + cores.isEmpty());
        System.out.println("A lista 'tempClear' (do passo 14) está vazia? " + tempClear.isEmpty());
        System.out.println("--------------------");

        System.out.println("26. Replace Element (Index 1)");
        int idxReplace = 1;
        String novoValor = "Turquesa";
        if (idxReplace >= 0 && idxReplace < cores.size()) {
            cores.set(idxReplace, novoValor);
        }
        System.out.println("Lista 'cores' após substituir índice " + idxReplace + ": " + cores);
        System.out.println("--------------------");
    }
}
