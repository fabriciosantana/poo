import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = input.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldoInicial);

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaPercent = input.nextDouble();

        SavingsAccount.setAnnualInterestRate(taxaPercent);

        System.out.printf("Saldos com taxa de juros de %.1f%%:%n", taxaPercent);

        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", mes, conta.getSavingsBalance());
        }

        System.out.print("Informe a nova taxa de juros anual: ");
        double novaTaxa = input.nextDouble();

        System.out.printf("Alterando taxa de juros anual para %.1f%%...%n", novaTaxa);

        SavingsAccount.setAnnualInterestRate(novaTaxa);

        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());

        input.close();
    }
}