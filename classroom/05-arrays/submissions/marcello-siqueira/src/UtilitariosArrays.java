import java.util.Arrays;

public class UtilitariosArrays {

    public static void main(String[] argumentos) {
        int[] numeros = {4, 1, 3, 2};
        System.out.println("Original: " + Arrays.toString(numeros));

        int[] copia = Arrays.copyOf(numeros, 6);
        System.out.println("copyOf com 6 posições: " + Arrays.toString(copia));

        Arrays.sort(numeros);
        System.out.println("Depois de sort: " + Arrays.toString(numeros));

        System.out.println("binarySearch do 3: índice " + Arrays.binarySearch(numeros, 3));

        System.out.println("equals com {1, 2, 3, 4}: " + Arrays.equals(numeros, new int[] {1, 2, 3, 4}));

        Arrays.fill(copia, 7);
        System.out.println("Cópia depois de fill: " + Arrays.toString(copia));

        System.out.println();
        System.out.println("numeros == new int[] {1, 2, 3, 4} dá " + (numeros == new int[] {1, 2, 3, 4}));
        System.out.println("O == compara referências, ou seja, pergunta se as duas variáveis alcançam");
        System.out.println("o mesmo objeto na memória. new cria um array novo, então são objetos");
        System.out.println("diferentes mesmo com os mesmos elementos. Para comparar conteúdo, Arrays.equals.");
    }
}
