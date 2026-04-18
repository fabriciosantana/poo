
public class SavingsAccount {
    
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance){
        if (savingsBalance<0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        } else {
            this.savingsBalance = savingsBalance;
        }
    }

    public void calculateMonthlyInterest(){
        double MonthlyInterest;
        if (SavingsAccount.annualInterestRate<0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        } else {
            MonthlyInterest = Math.pow((1 + SavingsAccount.annualInterestRate),(1.0/12)) -1;  
        }
        this.savingsBalance = this.savingsBalance*(1+MonthlyInterest);
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate<0) throw new IllegalArgumentException("A taxa de juros não pode ser negativa") ;
        SavingsAccount.annualInterestRate = annualInterestRate/100;
    }

    public static double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }



}
