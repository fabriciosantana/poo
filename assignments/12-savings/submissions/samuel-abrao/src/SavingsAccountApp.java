import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Solicita o saldo inicial
        System.out.print("Informe o saldo inicial: ");
        double initialBalance = input.nextDouble();

        // Solicita a taxa de juros anual em porcentagem
        System.out.print("Informe a taxa de juros anual (%): ");
        double annualInterestPercentage = input.nextDouble();
        double annualInterestRate = annualInterestPercentage / 100.0;

        SavingsAccount.setAnnualInterestRate(annualInterestRate);
        SavingsAccount account = new SavingsAccount(initialBalance);

        System.out.printf("Saldos com taxa de juros de %.1f%%:%n", annualInterestPercentage);
        for (int month = 1; month <= 12; month++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", month, account.getSavingsBalance());
        }

        // Solicita a nova taxa de juros anual
        System.out.print("Informe a nova taxa de juros anual (%): ");
        double newAnnualInterestPercentage = input.nextDouble();
        double newAnnualInterestRate = newAnnualInterestPercentage / 100.0;

        System.out.println("\nAlterando taxa de juros anual para " + newAnnualInterestPercentage + "%...");
        SavingsAccount.setAnnualInterestRate(newAnnualInterestRate);
        account.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", account.getSavingsBalance());

        input.close();
    }
}
