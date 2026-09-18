public class MediaVarargs {

    // Pre-condicao: media exige ao menos um valor. Sem argumento nao existe
    // media a calcular, entao o metodo lanca IllegalArgumentException em vez
    // de devolver zero, que seria confundido com uma media legitima de zero.

    public static void main(String[] argumentos) {
        System.out.println("media(4, 6, 8) = " + media(4, 6, 8));
        System.out.println("media(10) = " + media(10));

        double[] valores = {2.5, 3.5};
        System.out.println("media(array) = " + media(valores));

        try {
            media();
        } catch (IllegalArgumentException erro) {
            System.out.println("media() lançou IllegalArgumentException: " + erro.getMessage());
        }
    }

    static double media(double... valores) {
        if (valores.length == 0) {
            throw new IllegalArgumentException("informe ao menos um valor");
        }

        double soma = 0;
        for (double valor : valores) {
            soma += valor;
        }

        return soma / valores.length;
    }
}
