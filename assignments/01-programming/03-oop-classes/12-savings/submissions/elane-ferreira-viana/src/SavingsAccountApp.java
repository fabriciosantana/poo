import java.util.Scanner;

public class SavingsAccountApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxa = scanner.nextDouble() / 100;

        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxa);

        System.out.printf("%nSaldos com taxa de juros de %.1f%%%:%n",
                SavingsAccount.getAnnualInterestRate() * 100);

        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", mes, conta.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual (%): ");
        double novaTaxa = scanner.nextDouble() / 100;

        System.out.printf("%nAlterando taxa de juros anual para %.0f%%%...%n%n",
                novaTaxa * 100);

        SavingsAccount.setAnnualInterestRate(novaTaxa);
        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());

        scanner.close();
    }
}