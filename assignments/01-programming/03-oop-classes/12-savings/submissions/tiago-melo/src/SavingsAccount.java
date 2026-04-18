public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }

        this.savingsBalance = saldoInicial;
    }

    public void calculateMonthlyInterest() {
        double taxaMensal = Math.pow(1 + (annualInterestRate / 100.0), 1.0 / 12.0) - 1;
        savingsBalance += savingsBalance * taxaMensal;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double taxaJurosAnual) {
        if (taxaJurosAnual < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }

        SavingsAccount.annualInterestRate = taxaJurosAnual;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}
