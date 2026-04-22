import java.util.Scanner;

public class SavingsAccount {
    private double savingsBalance; //saldo atual da conta
    private static double annualInterestRate; //taxa de juros anual

    public SavingsAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.savingsBalance = initialBalance;
        } else {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
    }

    public void calculateMonthlyInterest() {
        double taxaMensal = Math.pow(1 + (annualInterestRate/100), 1/12.0) - 1; //calcula a taxa mensal a partir da taxa anual
        savingsBalance += savingsBalance * taxaMensal;
    }

    //getters
    public double getSavingsBalance() {
        return savingsBalance;
    }
    public double getAnnualInterestRate() {
        if (annualInterestRate >= 0) {
            return annualInterestRate;
        } else {
            throw new IllegalStateException("A taxa de juros anual não pode ser negativa.");
        }
    }

    //setters
    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        if (newAnnualInterestRate >= 0) {
            annualInterestRate = newAnnualInterestRate;
        } else {
            throw new IllegalArgumentException("A taxa de juros anual não pode ser negativa.");
        }
    }


}

