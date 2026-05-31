import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class LinkedListApp{
    public static void main(String[] args){
        LinkedList<String> colors = new LinkedList<>();

        colors.add("Azul");
        colors.add("Verde");
        colors.add("Amarelo");
        colors.add("Preto");
        System.out.println(colors);

        System.out.println("\nAppend Element:");
        colors.add("Branco");
        System.out.println(colors);

        System.out.println("\nIterate LinkedList Elements:");
        for(String color : colors){
            System.out.printf(color + " ");
        }
        System.out.println("");

        System.out.println("\nIterate from Position:");
        for(int i = 1; i < colors.size(); i++){
            System.out.printf(colors.get(i) + " ");
        }
        System.out.println("");

        System.out.println("\nIterate in Reverse Order:");
        Iterator<String> reverse = colors.descendingIterator();
        while(reverse.hasNext()){
            System.out.printf(reverse.next() + " ");
        }
        System.out.println("");

        System.out.println("\nInsert at Position:");
        colors.add(2, "Roxo");
        System.out.println(colors);

        System.out.println("\nInsert First and Last:");
        colors.addFirst("Cinza");
        colors.addLast("Ciano");
        System.out.println(colors);

        System.out.println("\nInsert at Front:");
        colors.addFirst("Marrom");
        System.out.println(colors);

        System.out.println("\nInsert at End:");
        colors.addLast("Rosa");
        System.out.println(colors);

        System.out.println("\nInsert Multiple at Position:");
        LinkedList<String> newColors = new LinkedList<>();
        newColors.add("Laranja");
        newColors.add("Prata");
        colors.addAll(4, newColors);
        System.out.println(colors);

        System.out.println("\nFirst and Last Occurrence:");
        colors.addLast("Azul");
        System.out.println(colors.indexOf("Azul"));
        System.out.println(colors.lastIndexOf("Azul"));

        System.out.println("\nPrint Elements with Positions:");
        for(int i = 0; i < colors.size(); i++){
            System.out.printf(i + "-" + colors.get(i) + " ");
        }
        System.out.println("");

        System.out.println("\nRemove Element:");
        colors.remove("Azul");
        System.out.println(colors);

        System.out.println("\nRemove First and Last:");
        colors.removeFirst();
        colors.removeLast();
        System.out.println(colors);

        System.out.println("\nClear LinkedList:");
        LinkedList<String> tempColors = new LinkedList<>(colors);
        tempColors.clear();
        System.out.println(tempColors);

        System.out.println("\nSwap Elements:");
        Collections.swap(colors, 0, 3);
        System.out.println(colors);

        System.out.println("\nShuffle LinkedList:");
        Collections.shuffle(colors);
        System.out.println(colors);

        System.out.println("\nJoin LinkedLists:");
        LinkedList<String> joined = new LinkedList<>(colors);
        joined.addAll(newColors);
        System.out.println(joined);

        System.out.println("\nCopy LinkedList:");
        LinkedList<String> copied = new LinkedList<>(colors);
        System.out.println(copied);

        System.out.println("\nPoll First Element:");
        System.out.println(colors.pollFirst());
        System.out.println(colors);

        System.out.println("\nPeek First Element:");
        System.out.println(colors.peekFirst());

        System.out.println("\nPeek Last Element:");
        System.out.println(colors.peekLast());

        System.out.println("\nContains Element:");
        System.out.println(colors.contains("Verde"));

        System.out.println("\nConvert to ArrayList:");
        ArrayList<String> arrayList = new ArrayList<>(colors);
        System.out.println(arrayList);

        System.out.println("\nCompare LinkedLists:");
        System.out.println(colors.equals(copied));

        System.out.println("\nCheck if Empty:");
        System.out.println(colors.isEmpty());

        System.out.println("\nReplace Element:");
        colors.set(1, "Turquesa");
        System.out.println(colors);
    }
}