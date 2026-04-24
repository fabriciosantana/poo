import java.util.Scanner;

public class SavingsAccountApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double annualRate = scanner.nextDouble() / 100;

        SavingsAccount account = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(annualRate);

        System.out.printf("%nSaldos com taxa de juros de %.1f%%:%n",
                          SavingsAccount.getAnnualInterestRate() * 100);

        for (int month = 1; month <= 12; month++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", month, account.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual (%): ");
        double newRate = scanner.nextDouble() / 100;

        System.out.printf("%nAlterando taxa de juros anual para %.0f%%%s%n",
                          newRate * 100, "...");

        SavingsAccount.setAnnualInterestRate(newRate);
        account.calculateMonthlyInterest();
        System.out.printf("%nMês 13: R$%.2f%n", account.getSavingsBalance());

        scanner.close();
    }
}