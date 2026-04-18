public class SavingsAccount {

    private double savingsBalance;
    private static double annualInterestRate;

    // Construtor
    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    // Método para calcular juros mensais
    public void calculateMonthlyInterest() {
        double monthlyRate = Math.pow(1 + annualInterestRate / 100, 1.0 / 12) - 1;
        savingsBalance += savingsBalance * monthlyRate;
    }

    // Getter da taxa
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // Setter da taxa
    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate;
    }

    // Getter do saldo
    public double getSavingsBalance() {
        return savingsBalance;
    }
}