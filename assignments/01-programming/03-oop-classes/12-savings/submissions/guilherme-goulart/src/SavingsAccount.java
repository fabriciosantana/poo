public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    // Método construtor
    public SavingsAccount(double savingsBalance){
        if(savingsBalance < 0){
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest(){
        double monthlyInterest = Math.pow(1 + annualInterestRate /100.0, (1.0/12.0)) - 1;
        double interest = this.savingsBalance * monthlyInterest;
    
        this.savingsBalance += interest;
    }

    public static void setAnnualInterestRate(double rate) {
        if(rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate;
    }

    public static double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }
    
}
