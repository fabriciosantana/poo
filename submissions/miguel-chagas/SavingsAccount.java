public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    /**
     * Constructs a SavingsAccount with an initial balance.
     * @param initialBalance initial balance, must be non‑negative
     * @throws IllegalArgumentException if initialBalance is negative
     */
    public SavingsAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = initialBalance;
    }

    /**
     * Sets the annual interest rate.
     * @param rate annual interest rate as a percentage (e.g., 4 for 4%)
     * @throws IllegalArgumentException if rate is negative
     */
    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate / 100.0; // store as decimal
    }

    /**
     * Returns the annual interest rate as a percentage.
     */
    public static double getAnnualInterestRate() {
        return annualInterestRate * 100.0;
    }

    /**
     * Calculates monthly interest and adds it to the balance.
     */
    public void calculateMonthlyInterest() {
        double monthlyRate = Math.pow(1 + annualInterestRate, 1.0 / 12.0) - 1;
        savingsBalance += savingsBalance * monthlyRate;
    }

    /**
     * Returns the current balance.
     */
    public double getSavingsBalance() {
        return savingsBalance;
    }
}
