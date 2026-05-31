import java.util.TreeSet;
import java.util.Collections;

public class TreeSetApp{

    public static void main(String[] args){
        TreeSet<String> colors = new TreeSet<>();

        colors.add("Verde");
        colors.add("Amarelo");
        colors.add("Azul");
        colors.add("Branco");

        System.out.println("Create and Print TreeSet:");
        System.out.println(colors);

        System.out.println("\nIterate TreeSet Elements:");
        for(String color : colors){
            System.out.println(color);
        }

        TreeSet<String> colors2 = new TreeSet<>();
        colors2.addAll(colors);
        System.out.println("\nAdd Elements to Another TreeSet:");
        System.out.println(colors2);

        System.out.println("\nReverse Order TreeSet:");
        System.out.println(colors.descendingSet());

        System.out.println("\nGet First and Last Elements:");
        System.out.println("Primeiro: " + colors.first());
        System.out.println("Último: " + colors.last());

        TreeSet<String> clone = (TreeSet<String>) colors.clone();
        System.out.println("\nClone TreeSet:");
        System.out.println(clone);

        System.out.println("\nTreeSet Size:");
        System.out.println(colors.size());

        System.out.println("\nCompare TreeSets:");
        System.out.println(colors.equals(colors2));

        System.out.println("\nCompare TreeSets:");
        System.out.println(colors.equals(colors2));

        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);
        numbers.add(9);
        System.out.println("\nElements Less Than 7:");
        System.out.println(numbers.headSet(7));

        System.out.println("\nCeiling Element:");
        System.out.println(numbers.ceiling(6));

        System.out.println("\nFloor Element:");
        System.out.println(numbers.floor(6));

        System.out.println("\nHigher Element:");
        System.out.println(numbers.higher(5));

        System.out.println("\nLower Element:");
        System.out.println(numbers.lower(5));

        System.out.println("\nPoll First Element:");
        System.out.println(numbers.pollFirst());
        System.out.println(numbers);

        System.out.println("\nPoll Last Element:");
        System.out.println(numbers.pollLast());
        System.out.println(numbers);

        System.out.println("\nRemove Element:");
        numbers.remove(5);
        System.out.println(numbers);
    }
}