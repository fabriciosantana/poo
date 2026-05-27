import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetApp {
    public static void main(String[] args) {
        HashSet<String> cores = new HashSet<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");

        System.out.println("1 Append Element to HashSet: " + cores);

        System.out.println("2 Iterate HashSet Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("3 Get HashSet Size: " + cores.size());

        HashSet<String> clone = new HashSet<>(cores);
        System.out.println("6 Clone HashSet: " + clone);

        String[] array = cores.toArray(new String[0]);
        System.out.println("7 Convert HashSet to Array: " + Arrays.toString(array));

        TreeSet<String> treeSet = new TreeSet<>(cores);
        System.out.println("8 Convert HashSet to TreeSet: " + treeSet);

        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);
        System.out.println("9 Find Elements Less Than 7: " + numeros.headSet(7));

        boolean iguais = cores.equals(clone);
        System.out.println("10 Compare Two HashSets: " + iguais);

        HashSet<String> outrasCores = new HashSet<>();
        outrasCores.add("Verde");
        outrasCores.add("Preto");
        HashSet<String> comuns = new HashSet<>(cores);
        comuns.retainAll(outrasCores);
        System.out.println("11 Retain Common Elements: " + comuns);

        cores.clear();
        System.out.println("4 Clear HashSet: " + cores);

        boolean vazio = cores.isEmpty();
        System.out.println("5 Check if HashSet is Empty: " + vazio);

        clone.clear();
        System.out.println("12 Remove All from HashSet: " + clone);
    }
}

