public class MediaVarargs {
    public static double media(double... valores) {
        if (valores.length == 0) {
            throw new IllegalArgumentException("Informe pelo menos um valor.");
        }
        double soma = 0.0;
        for (double valor : valores) {
            soma += valor;
        }
        return soma / valores.length;
    }

    public static void main(String[] args) {
        System.out.println(media(4, 6, 8));
        System.out.println(media(10));
        try {
            media();
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }
}
