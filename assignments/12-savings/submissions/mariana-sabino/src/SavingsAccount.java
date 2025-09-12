import java.util.Scanner;

public class SavingsAccount {

    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate / 100.0;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate * 100.0;
    }

    public void calculateMonthlyInterest() {
        double monthlyRate = Math.pow(1 + annualInterestRate, 1.0 / 12) - 1;
        savingsBalance += savingsBalance * monthlyRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static void main(String[] args) {
        SavingsAccountApp.run();
    }
}

class SavingsAccountApp {

    public static void run() {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = leitor.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaInicial = leitor.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxaInicial);

        System.out.printf("Saldos com taxa de juros de %.1f%%:%n", SavingsAccount.getAnnualInterestRate());
        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", mes, conta.getSavingsBalance());
        }

        System.out.print("Informe a nova taxa de juros anual: ");
        double novaTaxa = leitor.nextDouble();
        System.out.printf("Alterando taxa de juros anual para %.0f%%...%n%n", novaTaxa);
        SavingsAccount.setAnnualInterestRate(novaTaxa);

        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());

        leitor.close();
    }
}
