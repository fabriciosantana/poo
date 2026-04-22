public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O valor do saldo deve ser maior que zero");
        }
        this.savingsBalance = savingsBalance;
    }

    public static void modifyInterestRate(double taxaAnual) {
        if (taxaAnual < 0) {
            throw new IllegalArgumentException("O valor da taxa anual deve ser maior que zero");
        }
        annualInterestRate = taxaAnual;
    }

    public void calculateMonthlyInterest() {
        this.savingsBalance += (this.savingsBalance * annualInterestRate) / 12;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}