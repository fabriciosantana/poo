public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterestRate = Math.pow(1 + (annualInterestRate / 100.0), 1.0 / 12.0) - 1;
        this.savingsBalance += this.savingsBalance * monthlyInterestRate;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}