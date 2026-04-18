import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Informe o saldo inicial: ");
            double initialBalance = scanner.nextDouble();
            SavingsAccount account = new SavingsAccount(initialBalance);

            System.out.print("Informe a taxa de juros anual (%): ");
            double annualRate = scanner.nextDouble();
            SavingsAccount.setAnnualInterestRate(annualRate);

            System.out.println("Saldos com taxa de juros de " + annualRate + "%:");
            for (int month = 1; month <= 12; month++) {
                account.calculateMonthlyInterest();
                System.out.printf("Mês %d: R$%.2f%n", month, account.getSavingsBalance());
            }

            System.out.print("Informe a nova taxa de juros anual (%): ");
            double newAnnualRate = scanner.nextDouble();
            SavingsAccount.setAnnualInterestRate(newAnnualRate);
            System.out.println("Alterando taxa de juros anual para " + newAnnualRate + "%...");
            account.calculateMonthlyInterest();
            System.out.printf("Mês 13: R$%.2f%n", account.getSavingsBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
