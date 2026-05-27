import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetApp {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);

        System.out.println("1 Create and Print TreeSet: " + numeros);

        System.out.println("2 Iterate TreeSet Elements:");
        for (int numero : numeros) {
            System.out.println(numero);
        }

        TreeSet<Integer> outro = new TreeSet<>();
        outro.addAll(numeros);
        System.out.println("3 Add Elements to Another TreeSet: " + outro);

        NavigableSet<Integer> reverso = numeros.descendingSet();
        System.out.println("4 Reverse Order TreeSet: " + reverso);

        System.out.println("5 Get First and Last Elements: " + numeros.first() + ", " + numeros.last());

        TreeSet<Integer> clone = new TreeSet<>(numeros);
        System.out.println("6 Clone TreeSet: " + clone);

        System.out.println("7 TreeSet Size: " + numeros.size());

        boolean iguais = numeros.equals(outro);
        System.out.println("8 Compare TreeSets: " + iguais);

        System.out.println("9 Elements Less Than 7: " + numeros.headSet(7));

        System.out.println("10 Ceiling Element (4): " + numeros.ceiling(4));
        System.out.println("11 Floor Element (4): " + numeros.floor(4));
        System.out.println("12 Higher Element (4): " + numeros.higher(4));
        System.out.println("13 Lower Element (4): " + numeros.lower(4));

        Integer primeiroRemovido = numeros.pollFirst();
        System.out.println("14 Poll First Element: " + primeiroRemovido + " | " + numeros);

        Integer ultimoRemovido = numeros.pollLast();
        System.out.println("15 Poll Last Element: " + ultimoRemovido + " | " + numeros);

        numeros.remove(4);
        System.out.println("16 Remove Element (4): " + numeros);
    }
}

