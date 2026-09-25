public class CarteiraApp {

    public static void main(String[] argumentos) {
        Carteira carteira = new Carteira("Marcello Siqueira", -100.00);
        System.out.println("Saldo inicial normalizado: " + carteira.obterSaldo());

        carteira.depositar(500.00);
        System.out.println("Depósito de 500.00 aceito. Saldo: " + carteira.obterSaldo());

        try {
            carteira.sacar(200.00);
            System.out.println("Saque de 200.00 aceito. Saldo: " + carteira.obterSaldo());
        } catch (IllegalArgumentException erro) {
            System.out.println("Valor inválido: " + erro.getMessage());
        } catch (SaldoInsuficienteException erro) {
            System.out.println("Saldo insuficiente: " + erro.getMessage());
        }

        try {
            carteira.depositar(-50.00);
        } catch (IllegalArgumentException erro) {
            System.out.println("Valor inválido: " + erro.getMessage());
        }

        try {
            carteira.sacar(10000.00);
        } catch (IllegalArgumentException erro) {
            System.out.println("Valor inválido: " + erro.getMessage());
        } catch (SaldoInsuficienteException erro) {
            System.out.println("Saldo insuficiente: " + erro.getMessage());
        }

        System.out.println("Saldo final: " + carteira.obterSaldo());
    }
}
