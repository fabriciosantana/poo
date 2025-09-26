public class ArrayEmpty { 
    public static void main(String[] args) {
        
        int[] array = new int[10];
        
        System.out.printf("%s%8s%n", "Index", "Value"); // column headings 

        for (int counter = 0; counter < array.length; counter++) {
            System.out.printf("%5d%8d%n", counter, array[counter]); 
        }                                                         
    } 
} 