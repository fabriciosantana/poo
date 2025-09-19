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
        double mensal = (1 + annualInterestRate / 100.0) / 12.0 - 1;
        savingsBalance += savingsBalance * mensal;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa anual não pode ser negativa.");
        }
        annualInterestRate = rate;
    }
}
