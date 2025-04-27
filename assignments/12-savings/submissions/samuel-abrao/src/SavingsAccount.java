class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterestRate = Math.pow(1 + annualInterestRate, 1.0 / 12) - 1;
        savingsBalance += savingsBalance * monthlyInterestRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        if (newAnnualInterestRate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = newAnnualInterestRate;
    }
}
