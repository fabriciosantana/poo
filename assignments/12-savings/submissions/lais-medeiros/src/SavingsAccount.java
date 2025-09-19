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
        double taxaMensal = Math.pow(1 + annualInterestRate, 1.0 / 12.0) - 1;
        double juros = savingsBalance * taxaMensal;
        savingsBalance += juros;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate / 100.0; 
    }
}
