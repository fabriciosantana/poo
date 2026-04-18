import java.util.Scanner;

public class SavingsAccount {

    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance) {
        if(savingsBalance >= 0){
            this.setSavingsBalance(savingsBalance);  

        }else{
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");

        }
    }

    public void setSavingsBalance(double savingsBalance){
        if(savingsBalance >= 0){
            this.savingsBalance = savingsBalance;
        }else{
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
    }
    
     public static void setAnnualInterestRate(double annualInterestRate){
        if(annualInterestRate >= 0){
            SavingsAccount.annualInterestRate = annualInterestRate;

        }else{
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");

        }
    }

    public double getSavingsBalance(){return savingsBalance;}
    public static double getAnnualInterestRate(){return annualInterestRate;}

    public void calculateMonthlyInterest(){
        double taxaanual = annualInterestRate/100;
        double taxa = Math.pow((1 + taxaanual ), (1.0/12))-1;
        savingsBalance += savingsBalance * taxa;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Informe o saldo inicial: ");
        double saldo = ler.nextDouble();

        System.out.println("Informe a taxa de juros anual (%): ");
        double taxa = ler.nextDouble();

        SavingsAccount.setAnnualInterestRate(taxa);
        SavingsAccount conta = new SavingsAccount(saldo);

        for(int i = 1; i <= 12; i++){
        conta.calculateMonthlyInterest();
        System.out.println("Mês " + i + ": R$" + conta.getSavingsBalance());
 
        }

    }
}
