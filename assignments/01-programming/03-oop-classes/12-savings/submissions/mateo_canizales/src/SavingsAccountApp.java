import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Entrada do saldo inicial
        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = input.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldoInicial);

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaPercent = input.nextDouble();
        SavingsAccount.setAnnualInterestRate(taxaPercent / 100.0);

        System.out.printf("Saldos com taxa de juros de %.1f%%:%n", taxaPercent);
        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", mes, conta.getSavingsBalance());
        }

        System.out.print("Informe a nova taxa de juros anual: ");
        double novaTaxaPercent = input.nextDouble();
        System.out.printf("Alterando taxa de juros anual para %.0f%%...%n", novaTaxaPercent);
        SavingsAccount.setAnnualInterestRate(novaTaxaPercent / 100.0);

        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());

        input.close();
    }
}