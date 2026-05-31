import java.util.Arrays;
import java.util.TreeSet;
import java.util.HashSet;

public class HashSetApp{
    
    public static void main(String[] args){

        HashSet<String> hs = new HashSet<>();

        System.out.println("Append Element to HashSet:");
        hs.add("Beta");
        hs.add("Alpha");
        hs.add("Eta");
        hs.add("Gamma");
        hs.add("Epsilon");
        hs.add("Omega");

        System.out.println("\nIterate HashSet Elements:");
        for(String x : hs){
            System.out.printf(x + " ");
        }
        System.out.println("");

        System.out.println("\nGet HashSet Size:");
        System.out.println(hs.size());
        
        HashSet<String> tempHS = new HashSet<>(hs);
        System.out.println("\nClear HashSet:");
        tempHS.clear();
        System.out.println(tempHS);

        System.out.println("\nCheck if HashSet is Empty:");
        System.out.println(tempHS.isEmpty());

        HashSet<String> clonedHS = new HashSet<>(hs);
        System.out.println("\nClone HashSet:");
        System.out.println(clonedHS);

        System.out.println("\nConvert HashSet to Array:");
        String[] array = hs.toArray(new String[0]);
        System.out.println(Arrays.toString(array));

        System.out.println("\nConvert HashSet to TreeSet:");
        TreeSet<String> treeSet = new TreeSet<>(hs);
        System.out.println(treeSet);

        

    }
}