public class SavingsAccount {

    // atributo de classe para taxa anual
    private static double annualInterestRate = 0.0;

    // saldo atual da conta
    private double savingsBalance;

    // construtor
    public SavingsAccount(double savingsBalance) {
        // valida saldo inicial
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    // calcula juros do mes e adiciona ao saldo
    // usa a formula taxaMensal = (1 + taxaAnual)^(1/12) - 1
    public void calculateMonthlyInterest() {
        double monthlyRate = Math.pow(1.0 + annualInterestRate, 1.0 / 12.0) - 1.0;
        double interest = this.savingsBalance * monthlyRate;
        this.savingsBalance += interest;
    }

    // getter do saldo
    public double getSavingsBalance() {
        return savingsBalance;
    }

    // setter estatico da taxa anual
    // espera valor decimal por exemplo 0.04 para 4 por cento
    public static void setAnnualInterestRate(double rate) {
        // valida taxa
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate;
    }

    // getter estatico da taxa anual
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }
}
