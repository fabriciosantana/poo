public class Vendas {
    public static void main(String[] args) {
        int[][] vendas = {
            {10, 12, 8},
            {7, 9, 11}
        };

        int totalGeral = 0;

        // Total por loja (linhas)
        for (int i = 0; i < vendas.length; i++) {
            int totalLoja = 0;
            for (int j = 0; j < vendas[i].length; j++) {
                totalLoja += vendas[i][j];
            }
            totalGeral += totalLoja;
            System.out.println("Loja " + (i + 1) + ": " + totalLoja);
        }

        // Total por dia (colunas)
        // Assume que a matriz é regular para as colunas
        int totalDias = vendas[0].length;
        for (int j = 0; j < totalDias; j++) {
            int totalDia = 0;
            for (int i = 0; i < vendas.length; i++) {
                totalDia += vendas[i][j];
            }
            System.out.println("Dia " + (j + 1) + ": " + totalDia);
        }

        System.out.println("Total geral: " + totalGeral);
    }
}