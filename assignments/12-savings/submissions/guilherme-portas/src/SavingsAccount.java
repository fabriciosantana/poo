import java.lang.Math;

public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance) {
        if(savingsBalance < 0) throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        else this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }
    
    public static void setAnnualInterestRate(double annualInterestRate) {
        if(annualInterestRate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate() {
        return SavingsAccount.annualInterestRate;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterestRate = Math.pow(1 + annualInterestRate / 100d, 1d/12) - 1;
        savingsBalance += savingsBalance * monthlyInterestRate;
    }
}