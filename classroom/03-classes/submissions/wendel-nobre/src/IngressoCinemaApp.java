import java.util.Locale;

public class IngressoCinemaApp {
    public static void main(String[] args) {
        IngressoCinema ingresso = new IngressoCinema("Matrix", 30.0);

        System.out.println("--- Estado Inicial ---");
        exibir(ingresso);

        double valorPago1 = ingresso.venderMeia();
        System.out.printf(Locale.US, "Valor da 1ª venda (Meia): R$ %.2f%n", valorPago1);
        exibir(ingresso);

        double valorPago2 = ingresso.venderInteira();
        System.out.printf(Locale.US, "Valor da 2ª tentativa de venda: R$ %.2f%n", valorPago2);
        exibir(ingresso);
    }

    private static void exibir(IngressoCinema ingresso) {
        System.out.println("Filme: " + ingresso.obterFilme());
        System.out.printf(Locale.US, "Preço Inteira: R$ %.2f%n", ingresso.obterPrecoInteira());
        System.out.println("Vendido: " + (ingresso.estaVendido() ? "Sim" : "Não"));
        System.out.println();
    }
}