public class SavingsAccount {

    // taxa anual guardada em percentual: 12 significa 12%
    private static double annualInterestRate;

    private double savingsBalance;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public void calculateMonthlyInterest() {
        // taxa mensal equivalente: doze meses compostos rendem exatamente a taxa anual
        double monthlyRate = Math.pow(1 + annualInterestRate / 100, 1.0 / 12) - 1;
        savingsBalance += savingsBalance * monthlyRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}
