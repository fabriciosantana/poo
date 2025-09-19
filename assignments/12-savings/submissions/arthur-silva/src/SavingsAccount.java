
public class SavingsAccount {

    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = (this.savingsBalance * (annualInterestRate / 100.0)) / 12.0;
        this.savingsBalance += monthlyInterest;
    }

    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }
}