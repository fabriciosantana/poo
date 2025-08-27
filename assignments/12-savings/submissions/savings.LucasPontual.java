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
        double monthlyRate = Math.pow(1 + annualInterestRate, 1.0/12.0) - 1;
        savingsBalance += savingsBalance * monthlyRate;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double newRate) {
        if (newRate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = newRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}


