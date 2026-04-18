public class SavingsAccount{
    
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(){
    }

    public SavingsAccount(double savingsBalance){
        if(savingsBalance < 0){
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public static void setAnnualInterestRate(double rate){
        if(rate < 0){
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate;
    }

    public static double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public void calculateMonthlyInterest(){
        double decimal = annualInterestRate / 100.0;
        double monthlyInterest = Math.pow(1.0 + decimal,  1.0 / 12.0) - 1.0;
        savingsBalance += monthlyInterest * savingsBalance;
    }
}