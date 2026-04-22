public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0.0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        double annualRateDecimal = annualInterestRate / 100.0;

        double monthlyRate = Math.pow(1 + annualRateDecimal, 1.0 / 12.0) - 1;

        savingsBalance += savingsBalance * monthlyRate;
    }

    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        if (newAnnualInterestRate < 0.0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = newAnnualInterestRate;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getSavingsBalance() {
        return Math.round(savingsBalance * 100.0) / 100.0;
    }
}