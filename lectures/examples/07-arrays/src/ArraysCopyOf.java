import java.util.Arrays;

public class ArraysCopyOf {
    public static void main(String[] args) {

        int[] numbers = {2, 10, 9, 8, 1, -3};
        int[] numbers_copy = new int[numbers.length];
        int[] numbers_second_copy;
        
        System.out.println("Arrays inicializados");
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(numbers_copy));
                
        System.arraycopy(numbers, 0, numbers_copy, 0, numbers.length);
        numbers_second_copy = Arrays.copyOf(numbers, numbers.length);

        System.out.println("Após cópia");
        System.out.println(Arrays.toString(numbers) + " " + Arrays.hashCode(numbers));
        System.out.println(Arrays.toString(numbers_copy)  + " " + Arrays.hashCode(numbers_copy));
        System.out.println(Arrays.toString(numbers_second_copy)  + " " + Arrays.hashCode(numbers_second_copy));

        Arrays.sort(numbers);
        System.out.println("Após ordenação");
        System.out.println(Arrays.toString(numbers) + " " + Arrays.hashCode(numbers));
        System.out.println(Arrays.toString(numbers_copy) + " " + Arrays.hashCode(numbers_copy));
        System.out.println(Arrays.toString(numbers_second_copy) + " " + Arrays.hashCode(numbers_second_copy));

        System.out.println("Verificando se os arrays são iguais");
        System.out.println(Arrays.equals(numbers, numbers_copy));
        System.out.println(Arrays.equals(numbers_copy, numbers_second_copy));

        System.out.println("Comparando os arrays");
        System.out.println(Arrays.compare(numbers, numbers_copy));
        System.out.println(Arrays.compare(numbers_copy, numbers));
        System.out.println(Arrays.compare(numbers_copy, numbers_second_copy));

        System.out.println("Buscando elementos os arrays");
        int index = Arrays.binarySearch(numbers, 10); //o array precisa ser ordenado antes
        System.out.println("Índice: " + index+ ", valor: " + numbers[index]);

        index = Arrays.binarySearch(numbers,30);
        if (index < 0 || index >= numbers.length)
            System.out.println("Valor não encontrado, índice retornado " + index);

        index = Arrays.binarySearch(numbers,7);
        if (index < 0 || index >= numbers.length)
            System.out.println("Valor não encontrado, índice retornado " + index);

        index = Arrays.binarySearch(numbers,-4);
        if (index < 0 || index >= numbers.length)
            System.out.println("Valor não encontrado, índice retornado " + index);

        System.out.println("Atualizando valores dos arrays");
        Arrays.fill(numbers_copy, 5);
        Arrays.fill(numbers_second_copy, 0, numbers_second_copy.length/2, 7);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(numbers_copy));
        System.out.println(Arrays.toString(numbers_second_copy));

        System.out.println("Atualizando valores dos arrays");
        Arrays.fill(numbers_copy, 5);
        Arrays.fill(numbers_second_copy, 0, numbers_second_copy.length/2, 7);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(numbers_copy));
        System.out.println(Arrays.toString(numbers_second_copy));
    }
}
