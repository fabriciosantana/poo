import java.util.TreeSet;
import java.util.Iterator;
import java.util.Set;

public class TreeSetApp {

    public static void main(String[] args) {

        System.out.println("1. Create and Print TreeSet");
        TreeSet<String> cores = new TreeSet<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Branco");
        cores.add("Verde");
        System.out.println("TreeSet (ordenado alfabeticamente): " + cores);
        System.out.println("--------------------");

        System.out.println("2. Iterate TreeSet Elements");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println("--------------------");

        System.out.println("3. Add Elements to Another TreeSet");
        TreeSet<String> outroSet = new TreeSet<>();
        outroSet.add("Preto");
        outroSet.addAll(cores);
        System.out.println("Set Original: " + cores);
        System.out.println("Novo Set (com addAll): " + outroSet);
        System.out.println("--------------------");

        System.out.println("4. Reverse Order TreeSet");
        System.out.println("Visão em ordem reversa: " + cores.descendingSet());
        System.out.println("--------------------");

        System.out.println("5. Get First and Last Elements");
        System.out.println("Primeiro (menor): " + cores.first());
        System.out.println("Último (maior): " + cores.last());
        System.out.println("--------------------");

        System.out.println("6. Clone TreeSet");
        TreeSet<String> clone = (TreeSet<String>) cores.clone();
        System.out.println("Original: " + cores);
        System.out.println("Clone: " + clone);
        System.out.println("--------------------");

        System.out.println("7. TreeSet Size");
        System.out.println("Tamanho: " + cores.size());
        System.out.println("--------------------");

        System.out.println("8. Compare TreeSets");
        TreeSet<String> A = new TreeSet<>(cores);
        TreeSet<String> B = new TreeSet<>(cores);
        System.out.println("Set A: " + A);
        System.out.println("Set B: " + B);
        System.out.println("A e B são iguais? " + A.equals(B));
        B.add("Preto");
        System.out.println("Set B modificado: " + B);
        System.out.println("A e B são iguais? " + A.equals(B));
        System.out.println("--------------------");

        System.out.println("(Configurando TreeSet de números para os próximos testes)");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(8);
        numeros.add(3);
        numeros.add(10);
        numeros.add(7);
        System.out.println("TreeSet de números: " + numeros);
        System.out.println("--------------------");

        System.out.println("9. Elements Less Than 7");
        Set<Integer> menoresQue7 = numeros.headSet(7);
        System.out.println("Elementos menores (estrito) que 7: " + menoresQue7);
        System.out.println("--------------------");

        System.out.println("10. Ceiling Element (>= valor)");
        int valorCeiling = 6;
        System.out.println("Elemento >= " + valorCeiling + ": " + numeros.ceiling(valorCeiling));
        System.out.println("Elemento >= 5: " + numeros.ceiling(5));
        System.out.println("--------------------");

        System.out.println("11. Floor Element (<= valor)");
        int valorFloor = 6;
        System.out.println("Elemento <= " + valorFloor + ": " + numeros.floor(valorFloor));
        System.out.println("Elemento <= 5: " + numeros.floor(5));
        System.out.println("--------------------");

        System.out.println("12. Higher Element (> valor)");
        System.out.println("Elemento > 5: " + numeros.higher(5));
        System.out.println("--------------------");

        System.out.println("13. Lower Element (< valor)");
        System.out.println("Elemento < 5: " + numeros.lower(5));
        System.out.println("--------------------");

        System.out.println("14. Poll First Element");
        System.out.println("Set 'cores' antes: " + cores);
        String first = cores.pollFirst();
        System.out.println("Elemento removido (pollFirst): " + first);
        System.out.println("Set 'cores' depois: " + cores);
        System.out.println("--------------------");

        System.out.println("15. Poll Last Element");
        System.out.println("Set 'cores' antes: " + cores);
        String last = cores.pollLast();
        System.out.println("Elemento removido (pollLast): " + last);
        System.out.println("Set 'cores' depois: " + cores);
        System.out.println("--------------------");

        System.out.println("16. Remove Element ('Verde')");
        boolean removido = cores.remove("Verde");
        System.out.println("Elemento 'Verde' foi removido? " + removido);
        System.out.println(cores);
        System.out.println("--------------------");
    }
}
