public class SavingsAccount {

    private double savingsBalance;                  // saldo da conta
    private static double annualInterestRate = 0;   // taxa anual (ex.: 0.04 = 4%)

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    // Juros mensais efetivos: ((1 + taxaAnual)^(1/12)) - 1
    public void calculateMonthlyInterest() {
        double monthlyRate = Math.pow(1.0 + annualInterestRate, 1.0 / 12.0) - 1.0;
        double interest = savingsBalance * monthlyRate;
        savingsBalance += interest;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    // Getter/Setter da taxa anual (valor decimal: 0.04 = 4%)
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate;
    }
}
