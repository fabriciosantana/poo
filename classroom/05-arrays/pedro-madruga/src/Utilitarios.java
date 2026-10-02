import java.util.Arrays;

public class Utilitarios {
    public static void main(String[] args) {
        int[] numeros = {4, 1, 3, 2};
        System.out.println("Original (toString): " + Arrays.toString(numeros));

        // Cópia com 6 posições (as duas últimas serão preenchidas com 0 por padrão)
        int[] copia = Arrays.copyOf(numeros, 6);
        System.out.println("Cópia (tamanho 6): " + Arrays.toString(copia));

        // Ordenação
        Arrays.sort(numeros);
        System.out.println("Original ordenado: " + Arrays.toString(numeros));

        // Busca binária (pré-requisito: o array DEVE estar ordenado)
        int indice3 = Arrays.binarySearch(numeros, 3);
        System.out.println("Índice do elemento 3: " + indice3);

        // Comparação de conteúdo
        int[] esperado = {1, 2, 3, 4};
        boolean conteudoIgual = Arrays.equals(numeros, esperado);
        System.out.println("Arrays.equals(numeros, {1,2,3,4}): " + conteudoIgual);

        // Preenchimento
        Arrays.fill(copia, 7);
        System.out.println("Cópia após Arrays.fill com 7: " + Arrays.toString(copia));

        /*
         * Resposta à pergunta:
         * A expressão (numeros == new int[] {1, 2, 3, 4}) retorna false porque o operador '=='
         * em objetos e arrays compara a identidade de referência (se ambos apontam para o
         * mesmo endereço de memória), e não o conteúdo interno de suas posições.
         * Como 'new' aloca uma nova área no Heap, as referências são distintas.
         */
    }
}