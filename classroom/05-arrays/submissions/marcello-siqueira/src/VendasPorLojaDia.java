public class VendasPorLojaDia {

    public static void main(String[] argumentos) {
        int[][] vendas = {{10, 12, 8}, {7, 9, 11}};
        totalizar(vendas);

        System.out.println();
        totalizar(new int[][] {{5, 5}, {1, 2}, {0, 4}});
    }

    static void totalizar(int[][] vendas) {
        int totalGeral = 0;

        for (int loja = 0; loja < vendas.length; loja++) {
            int totalLoja = 0;
            for (int dia = 0; dia < vendas[loja].length; dia++) {
                totalLoja += vendas[loja][dia];
            }
            System.out.println("Loja " + (loja + 1) + ": " + totalLoja);
            totalGeral += totalLoja;
        }

        int quantidadeDias = vendas.length == 0 ? 0 : vendas[0].length;

        for (int dia = 0; dia < quantidadeDias; dia++) {
            int totalDia = 0;
            for (int loja = 0; loja < vendas.length; loja++) {
                if (dia < vendas[loja].length) {
                    totalDia += vendas[loja][dia];
                }
            }
            System.out.println("Dia " + (dia + 1) + ": " + totalDia);
        }

        System.out.println("Total geral: " + totalGeral);
    }
}
