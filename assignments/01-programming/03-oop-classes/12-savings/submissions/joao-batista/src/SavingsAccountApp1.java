import java.util.Scanner;

public class SavingsAccountApp1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxa = scanner.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxa / 100);

        System.out.printf("%nSaldos com taxa de juros de %.1f%%:%n", taxa);

        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", mes, conta.getSavingsBalance());
        }

        System.out.printf("%nInforme a nova taxa de juros anual: ");
        double novaTaxa = scanner.nextDouble();

        SavingsAccount.setAnnualInterestRate(novaTaxa / 100);
        System.out.printf("%nAlterando taxa de juros anual para %.0f%%...%n%n", novaTaxa);

        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());

        scanner.close();
    }
}