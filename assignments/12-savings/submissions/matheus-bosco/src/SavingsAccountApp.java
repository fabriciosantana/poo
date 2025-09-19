import java.util.Scanner;

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
        double taxaMensal = Math.pow(1 + annualInterestRate / 100.0, 1.0 / 12.0) - 1;
        savingsBalance += savingsBalance * taxaMensal;
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
        annualInterestRate = rate;
    }
}

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = input.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaInicial = input.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxaInicial);

        System.out.printf("%nSaldos com taxa de juros de %.1f%%%n", taxaInicial);
        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", mes, conta.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual: ");
        double novaTaxa = input.nextDouble();
        SavingsAccount.setAnnualInterestRate(novaTaxa);

        System.out.printf("%nAlterando taxa de juros anual para %.1f%%%n", novaTaxa);
        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());

        input.close();
    }
}
