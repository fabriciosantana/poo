/**
 * A classe SavingsAccount representa uma conta poupança que acumula juros mensalmente.
 * A taxa de juros é um atributo estático, compartilhado por todas as contas.
 *
 * Referência: DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed.
 */
public class SavingsAccount {

    // Atributo de classe (static) para a taxa de juros anual.
    // É compartilhado por todos os objetos da classe.
    private static double annualInterestRate;

    // Atributo de instância para o saldo da conta.
    // Cada objeto terá seu próprio valor.
    private double savingsBalance;

    /**
     * Construtor que inicializa uma conta poupança com um saldo inicial.
     *
     * @param initialBalance O saldo inicial da conta.
     * @throws IllegalArgumentException se o saldo inicial for negativo.
     */
    public SavingsAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = initialBalance;
    }

    /**
     * Calcula o juro mensal e o adiciona ao saldo da conta.
     * A fórmula utilizada é (saldo * taxaAnual) / 12 para corresponder ao exemplo.
     */
    public void calculateMonthlyInterest() {
        double monthlyInterest = (this.savingsBalance * annualInterestRate) / 12.0;
        this.savingsBalance += monthlyInterest;
    }

    /**
     * Modifica a taxa de juros anual.
     * Como o método é estático, ele altera a taxa para TODAS as contas.
     *
     * @param newRate A nova taxa de juros anual (em formato decimal, ex: 0.04 para 4%).
     * @throws IllegalArgumentException se a taxa for negativa.
     */
    public static void setAnnualInterestRate(double newRate) {
        if (newRate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = newRate;
    }

    /**
     * Retorna a taxa de juros anual atual.
     * @return a taxa de juros anual.
     */
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Retorna o saldo atual da conta.
     * @return o saldo atual.
     */
    public double getSavingsBalance() {
        return this.savingsBalance;
    }
}