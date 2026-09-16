public class VendasMatriz {
    public static void main(String[] args) {
        int[][] vendas = {{10, 12, 8}, {7, 9, 11}};
        int totalGeral = 0;

        for (int linha = 0; linha < vendas.length; linha++) {
            int totalLoja = 0;
            for (int coluna = 0; coluna < vendas[linha].length; coluna++) {
                totalLoja += vendas[linha][coluna];
            }
            totalGeral += totalLoja;
            System.out.println("Loja " + (linha + 1) + ": " + totalLoja);
        }

        int quantidadeDias = vendas.length == 0 ? 0 : vendas[0].length;
        for (int coluna = 0; coluna < quantidadeDias; coluna++) {
            int totalDia = 0;
            for (int linha = 0; linha < vendas.length; linha++) {
                if (coluna < vendas[linha].length) {
                    totalDia += vendas[linha][coluna];
                }
            }
            System.out.println("Dia " + (coluna + 1) + ": " + totalDia);
        }

        System.out.println("Total geral: " + totalGeral);
    }
}
