public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial nao pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate < 0) {
            throw new IllegalArgumentException("A taxa de juros nao pode ser negativa.");
        }
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void modifyInterestRate(double annualInterestRate) {
        setAnnualInterestRate(annualInterestRate);
    }

    public void calculateMonthlyInterest() {
        double monthlyRate = Math.pow(1 + (annualInterestRate / 100.0), (1.0 / 12.0)) - 1;
        savingsBalance += savingsBalance * monthlyRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}
