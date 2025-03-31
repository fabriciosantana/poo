import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double annualInterestRate = scanner.nextDouble();

        SavingsAccount account = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(annualInterestRate);

        System.out.printf("Saldos com taxa de juros de %.1f%%:\n", annualInterestRate);
        for (int month = 1; month <= 12; month++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f\n", month, account.getSavingsBalance());
        }

        System.out.print("Informe a nova taxa de juros anual (%): ");
        double newAnnualInterestRate = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(newAnnualInterestRate);

        System.out.println("\nAlterando taxa de juros anual para " + newAnnualInterestRate + "%...");
        account.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f\n", account.getSavingsBalance());

        scanner.close();
    }
}