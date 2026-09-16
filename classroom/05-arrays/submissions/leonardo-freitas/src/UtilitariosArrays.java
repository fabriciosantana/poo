import java.util.Arrays;

public class UtilitariosArrays {
    public static void main(String[] args) {
        int[] numeros = {4, 1, 3, 2};
        System.out.println("Original: " + Arrays.toString(numeros));

        int[] copia = Arrays.copyOf(numeros, 6);
        System.out.println("Cópia com 6 posições: " + Arrays.toString(copia));

        Arrays.sort(numeros);
        System.out.println("Ordenado: " + Arrays.toString(numeros));

        int indice = Arrays.binarySearch(numeros, 3);
        System.out.println("Índice do 3: " + indice);

        System.out.println("Conteúdo igual: " + Arrays.equals(numeros, new int[]{1, 2, 3, 4}));

        Arrays.fill(copia, 7);
        System.out.println("Cópia preenchida: " + Arrays.toString(copia));

        // == compara se as duas variáveis apontam para o mesmo objeto de array, não seus elementos.
        System.out.println("Comparação com ==: " + (numeros == new int[]{1, 2, 3, 4}));
    }
}
