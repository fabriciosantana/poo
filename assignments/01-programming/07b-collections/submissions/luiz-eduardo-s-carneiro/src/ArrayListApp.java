import java.util.ArrayList;
import java.util.Collections;

public class ArrayListApp{

    public static void main(String[] args){

        System.out.println("Create and Print ArrayList");
        ArrayList<String> colors = new ArrayList();

        colors.add("Verde");
        colors.add("Amarelo");
        colors.add("Azul");
        colors.add("Branco");

        System.out.println("\nIterate ArrayList Elements");
        for(String color : colors){
            System.out.println(color);
        }

        System.out.println("\nInsert at First Position");
        colors.add(0, "Vermelho");
        System.out.println(colors);

        System.out.println("\nRetrieve Element by Index");
        if(colors.size() > 2){
            System.out.println(colors.get(2));
        }

        System.out.println("\nOperação: Update ArrayList Element");
        String antiga = colors.set(4, "Preto");
        System.out.println(colors);
        
        System.out.println("\nRemove Third Element");
        if(colors.size() > 2){
            colors.remove(2);
        }
        System.out.println(colors);

        System.out.println("\nSearch Element in ArrayList:");
        System.out.println(colors.contains("Azul"));

        System.out.println("\nSort ArrayList:");
        Collections.sort(colors);
        System.out.println(colors);

        System.out.println("\nCopy ArrayList:");
        ArrayList<String> copyColors = new ArrayList(colors);
        System.out.println(copyColors);

        System.out.println("\nShuffle ArrayList:");
        Collections.shuffle(colors);
        System.out.println(colors);

        System.out.println("\nReverse ArrayList:");
        Collections.reverse(colors);
        System.out.println(colors);

        System.out.println("\nExtract Sublist from ArrayList:");
        if(colors.size() >= 2){
            System.out.println(colors.subList(0, 2));
        }

        System.out.println("\nCompare Two ArrayLists:");
        System.out.println(colors.equals(copyColors));

        System.out.println("\nSwap ArrayList Elements:");
        if(colors.size() > 1){
            Collections.swap(colors, 0, 1);
        }
        System.out.println(colors);

        System.out.println("\nJoin Two ArrayLists:");
        ArrayList<String> joinedList = new ArrayList<>(colors);
        joinedList.addAll(copyColors);
        System.out.println(joinedList);

        System.out.println("\nClone ArrayList:");
        ArrayList<String> clonedList = (ArrayList<String>) colors.clone();
        System.out.println(clonedList);

        System.out.println("\nClear ArrayList:");
        colors.clear();
        System.out.println(colors);

        System.out.println("\nCheck if ArrayList is Empty:");
        System.out.println(colors.isEmpty());

        System.out.println("\nTrim ArrayList Capacity:");
        copyColors.trimToSize();
        System.out.println(copyColors);

        System.out.println("\nIncrease ArrayList Capacity:");
        copyColors.ensureCapacity(20);
        System.out.println("Capacidade aumentada.");

        System.out.println("\nReplace Second Element:");
        if (copyColors.size() > 1) {
            copyColors.set(1, "Roxo");
        }
        System.out.println(copyColors);

        System.out.println("\nPrint Elements by Position:");
        for (int i = 0; i < copyColors.size(); i++) {
            System.out.println(i + " -> " + copyColors.get(i));
        }
    }
}