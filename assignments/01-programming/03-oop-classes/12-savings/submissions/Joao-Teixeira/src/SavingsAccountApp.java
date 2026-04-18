import java.util.Locale;
import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double annualRate = scanner.nextDouble();

        SavingsAccount account = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(annualRate);

        System.out.printf("Saldos com taxa de juros de %.1f%%:\n", annualRate);
        for (int i = 1; i <= 12; i++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f\n", i, account.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual: ");
        String newRateStr = scanner.next();
        double newRate = Double.parseDouble(newRateStr.replace("%", ""));

        System.out.printf("\nAlterando taxa de juros anual para %.0f%%...\n\n", newRate);
        SavingsAccount.setAnnualInterestRate(newRate);
        
        account.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f\n", account.getSavingsBalance());

        scanner.close();
    }
}