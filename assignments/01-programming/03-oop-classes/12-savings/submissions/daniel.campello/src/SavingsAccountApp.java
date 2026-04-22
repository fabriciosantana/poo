import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();

        SavingsAccount account = new SavingsAccount(initialBalance);

        System.out.print("Informe a taxa de juros anual (%): ");
        double rate = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(rate);

        for (int month = 1; month <= 12; month++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mes %d: R$%.2f%n", month, account.getSavingsBalance());
        }

        System.out.print("Informe a nova taxa de juros anual (%): ");
        double newRate = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(newRate);

        account.calculateMonthlyInterest();
        System.out.printf("Mes 13: R$%.2f%n", account.getSavingsBalance());

        scanner.close();
    }
}
