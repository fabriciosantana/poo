public class ArrayAsParameterToMethods {
    public static void main(String[] args) {
        int[] array = {1, 2};
        System.out.printf("Original array: %s%s%n", array[0], array[1]);	
        modifyArray(array);
        System.out.printf("Modified array: %s%s%n", array[0], array[1]);
    }    

    public static void modifyArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
    }
}
