import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double annualInterestRate = scanner.nextDouble();

        SavingsAccount.setAnnualInterestRate(annualInterestRate);
        SavingsAccount account = new SavingsAccount(initialBalance);
        System.out.printf("Saldos para taxa de juros de %.2f%%...\n", annualInterestRate);
        for (int month = 1; month <= 12; month++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", month, account.getSavingsBalance());
        }

        System.out.print("Informe a nova taxa de juros anual (%): ");
        annualInterestRate = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(annualInterestRate);
        System.out.print("Alterando taxa de juros anual para 5%...\n\n");
        account.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", account.getSavingsBalance());
    }
}
