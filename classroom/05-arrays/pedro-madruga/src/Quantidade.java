public class Quantidade {
    public static void main(String[] args) {
        System.out.println("Média (4, 6, 8): " + media(4, 6, 8));
        System.out.println("Média (10): " + media(10));

        // Teste de caso de erro (sem argumentos)
        try {
            media();
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção esperada ao chamar sem valores: " + e.getMessage());
        }
    }

    /**
     * Calcula a média aritmética de uma lista variável de números.
     *
     * Pré-condição: deve ser fornecido pelo menos um argumento.
     * @param valores Sequência de números double.
     * @return Média aritmética dos valores.
     * @throws IllegalArgumentException se nenhum argumento for fornecido.
     */
    public static double media(double... valores) {
        if (valores.length == 0) {
            throw new IllegalArgumentException("É necessário fornecer ao menos um valor.");
        }

        double soma = 0.0;
        for (double v : valores) {
            soma += v;
        }

        return soma / valores.length;
    }
}