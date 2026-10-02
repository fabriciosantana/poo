public class Busca {
    public static void main(String[] args) {
        int[] valores = {4, 7, 4, 9};

        int[] alvos = {4, 9, 5};
        for (int alvo : alvos) {
            int pos = buscar(valores, alvo);
            System.out.printf("Busca pelo alvo %d: índice %d%n", alvo, pos);
        }

        System.out.println("\n--- Validação de acesso direto ---");
        acessarIndice(valores, 2);
        acessarIndice(valores, -1);
        acessarIndice(valores, 4);
    }

    public static int buscar(int[] valores, int alvo) {
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == alvo) {
                return i; // Devolve a primeira ocorrência imediatamente
            }
        }
        return -1; // Sentinela de elemento inexistente
    }

    public static void acessarIndice(int[] array, int indice) {
        if (indice >= 0 && indice < array.length) {
            System.out.printf("Posição %d contém: %d%n", indice, array[indice]);
        } else {
            System.out.printf("Posição %d: INDICE INVALIDO%n", indice);
        }
    }
}