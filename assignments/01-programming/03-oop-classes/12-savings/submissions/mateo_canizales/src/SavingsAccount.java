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
        if (annualInterestRate == 0.0) {
            return; // evita divisão por zero ou comportamento estranho
        }

        double monthlyInterestRate = annualInterestRate / 12.0;

        double interest = savingsBalance * monthlyInterestRate;
        savingsBalance += interest;

        savingsBalance = Math.round(savingsBalance * 100.0) / 100.0;
    }

    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        if (newAnnualInterestRate < 0.0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        SavingsAccount.annualInterestRate = newAnnualInterestRate;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}