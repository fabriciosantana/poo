public class Linhas {
    public static void main(String[] args) {
        // Matriz irregular com uma linha vazia inclusa
        int[][] respostas = {
            {1, 0, 1},
            {0},
            {1, 1},
            {} // Linha vazia
        };

        for (int i = 0; i < respostas.length; i++) {
            int quantidade = respostas[i].length;
            int soma = 0;

            for (int j = 0; j < quantidade; j++) {
                soma += respostas[i][j];
            }

            System.out.println("Linha " + i + " -> Qtd: " + quantidade + " | Soma: " + soma);
        }
    }
}