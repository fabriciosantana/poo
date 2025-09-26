import java.util.Scanner;

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
        double monthlyInterestRate = Math.pow((1 + annualInterestRate), (1.0 / 12.0)) - 1;
        double monthlyInterest = this.savingsBalance * monthlyInterestRate;
        this.savingsBalance += monthlyInterest;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public static void setAnnualInterestRate(double newRate) {
        if (newRate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        
        annualInterestRate = newRate / 100.0;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate * 100.0;
    }
}