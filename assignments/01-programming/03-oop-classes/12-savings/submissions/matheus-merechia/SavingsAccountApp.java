import java.util.Scanner;

public class SavingsAccountApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldo = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxa = scanner.nextDouble() / 100.0;

        SavingsAccount conta = new SavingsAccount(saldo);
        SavingsAccount.setAnnualInterestRate(taxa);

        System.out.printf("\nSaldos com taxa de juros de %.1f%%:\n", taxa * 100);

        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f\n", mes, conta.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual (%): ");
        double novaTaxa = scanner.nextDouble() / 100.0;

        SavingsAccount.setAnnualInterestRate(novaTaxa);

        System.out.println("\nAlterando taxa de juros anual para " + (novaTaxa * 100) + "%...\n");

        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f\n", conta.getSavingsBalance());

        scanner.close();
    }
}
