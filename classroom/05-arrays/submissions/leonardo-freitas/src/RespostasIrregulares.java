public class RespostasIrregulares {
    public static void main(String[] args) {
        int[][] respostas = {{1, 0, 1}, {0}, {1, 1}, {}};
        for (int linha = 0; linha < respostas.length; linha++) {
            int soma = 0;
            for (int valor : respostas[linha]) {
                soma += valor;
            }
            System.out.println("Linha " + (linha + 1)
                    + " | Quantidade: " + respostas[linha].length
                    + " | Soma: " + soma);
        }
    }
}
