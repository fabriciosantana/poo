public class CarteiraApp {
    public static void main(String[] args) {
        Carteira carteira = new Carteira("Leonardo", 100.0);

        carteira.depositar(50.0);

        try {
            carteira.sacar(30.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        try {
            carteira.depositar(0.0);
        } catch (IllegalArgumentException e) {
            System.out.println("VALOR INVALIDO");
        }

        try {
            carteira.sacar(500.0);
        } catch (IllegalArgumentException e) {
            System.out.println("VALOR INVALIDO");
        } catch (SaldoInsuficienteException e) {
            System.out.println("SALDO INSUFICIENTE");
        }

        System.out.printf("Saldo final: R$ %.2f%n", carteira.getSaldo());
    }
}
