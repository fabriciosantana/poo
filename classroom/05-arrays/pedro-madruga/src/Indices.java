public class Indices {
    public static void main(String[] args) {
        int[] valores = {32, 27, 64, 18, 95};
        testarArray(valores);

        System.out.println("\n--- Teste com 1 elemento ---");
        int[] unitario = {42};
        testarArray(unitario);
    }

    private static void testarArray(int[] array) {
        if (array.length == 0) {
            System.out.println("Array vazio.");
            return;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.printf("Índice %d: %d%n", i, array[i]);
        }

        System.out.println("Primeiro elemento: " + array[0]);
        System.out.println("Último elemento: " + array[array.length - 1]);

        /*
         * EXPLICAÇÃO:
         * Em Java, a indexação começa em 0. Um array de tamanho N possui índices
         * válidos de 0 até (N - 1). Acessar 'array[array.length]' tenta buscar o
         * índice N (a posição N + 1), lançando ArrayIndexOutOfBoundsException.
         */
    }
}