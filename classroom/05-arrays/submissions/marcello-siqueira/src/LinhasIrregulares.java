public class LinhasIrregulares {

    public static void main(String[] argumentos) {
        int[][] respostas = {{1, 0, 1}, {0}, {1, 1}};
        resumir(respostas);

        System.out.println();
        System.out.println("Com uma linha vazia no meio:");
        resumir(new int[][] {{1, 0, 1}, {}, {0}, {1, 1}});
    }

    static void resumir(int[][] respostas) {
        for (int linha = 0; linha < respostas.length; linha++) {
            int soma = 0;

            for (int coluna = 0; coluna < respostas[linha].length; coluna++) {
                soma += respostas[linha][coluna];
            }

            System.out.println("Linha " + (linha + 1) + ": " + respostas[linha].length
                    + " resposta(s), soma " + soma);
        }
    }
}
