public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

   
    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    
    public static void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }


    public void calculateMonthlyInterest() {
        if (annualInterestRate == 0) {
            return;
        }
        double multiplier = Math.pow(1.0 + annualInterestRate / 100.0, 1.0 / 12.0);
        savingsBalance *= multiplier;
    }

   
    public double getSavingsBalance() {
        return savingsBalance;
    }
}