
import java.util.Arrays;
import java.util.List;

public class ArrayToList {
    public static void main(String... args){
        Integer[] numbers = {1, 2, 3, 4};

        List<Integer> numbersArrayList = Arrays.asList(numbers);

        for (Integer i : numbersArrayList){
            System.out.println("Number: " + i);
        }
    }
}
