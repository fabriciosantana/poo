
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
        double monthlyInterestRate = annualInterestRate / 12.0;
        double interest = savingsBalance * monthlyInterestRate;
        savingsBalance += interest;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate < 0.0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }
}