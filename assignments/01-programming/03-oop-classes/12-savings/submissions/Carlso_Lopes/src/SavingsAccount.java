public class SavingsAccount {
    private double savingsbalance;
    private static double annulInterestRate;

    //Constructor
    public SavingsAccount(double savingsbalance, double annulInterestRate){
        if (savingsbalance < 0) {
        throw new IllegalArgumentException("Saldo não pode ser negativo");
    }
        this.savingsbalance = savingsbalance;

        if (annulInterestRate < 0){
        throw new IllegalArgumentException("A taxa de Juros não pode ser negativa.");
    }
        this.annulInterestRate= annulInterestRate;
    }
    //Get e Set
    public double getSavingsBalance(){ return savingsbalance; }
    public double getAnnulInterestRate(){ return annulInterestRate; }
    public void setSavingsBalance(double savingsbalance) {
        if (savingsbalance < 0) {
        throw new IllegalArgumentException("Saldo não pode ser negativo.");
    }
    this.savingsbalance = savingsbalance;
    }
    public void setAnnulInterestRate(double annulInterestRate) {
        if (annulInterestRate < 0) {
        throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
    }
    this.annulInterestRate = annulInterestRate;
    }

    public void calculateMonthlyInterest(){

        double MonthlyInterest = (annulInterestRate / 100) / 12.0;

        savingsbalance = savingsbalance * (1.0 + MonthlyInterest);
        }
    }
    