import java.util.Scanner;
import java.util.Locale;

class SavingsAccount{
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double savingsBalance){
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest(){
        double monthlyRate = Math.pow(1 + (annualInterestRate / 100.0), 1.0 / 12.0) - 1.0;
        this.savingsBalance += this.savingsBalance * monthlyRate;
    }

    public static void setAnnualInterestRate(double rate){
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate;
    }

    public static double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }
}

public class SavingsAccountApp{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxa = sc.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxa);

        System.out.printf("%nSaldos com taxa de juros de %.1f%%%n", taxa);

        for(int mes = 1; mes <= 12; mes++){
            conta.calculateMonthlyInterest();
            System.out.printf("%nMês %d: R$%.2f", mes, conta.getSavingsBalance());
        }

        System.out.printf("%n%n");
        System.out.print("Informe a nova taxa de juros anual (%): ");
        double novaTaxa = sc.nextDouble();
        SavingsAccount.setAnnualInterestRate(novaTaxa);

        System.out.printf("%nAlterando taxa de juros anual para %.1f%%%n%n", novaTaxa);
        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());

        sc.close();
    }
}
