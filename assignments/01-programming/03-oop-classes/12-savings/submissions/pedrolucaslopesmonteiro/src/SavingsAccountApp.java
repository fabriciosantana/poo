import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double rate = scanner.nextDouble();

        SavingsAccount account = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(rate);

        System.out.printf("%nSaldos com taxa de juros de %.1f%%:%n", rate);

        for (int month = 1; month <= 12; month++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", month, account.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual (%): ");
        double newRate = scanner.nextDouble();

        SavingsAccount.setAnnualInterestRate(newRate);
        System.out.printf("%nAlterando taxa de juros anual para %.0f%%...%n%n", newRate);

        account.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", account.getSavingsBalance());

        scanner.close();
    }
}