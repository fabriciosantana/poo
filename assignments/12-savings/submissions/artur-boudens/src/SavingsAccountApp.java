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

        System.out.printf("Saldos com taxa de juros de %.1f: ", annualRate);
        for(int i = 1; i < 13; i++){
            account.calculateMonthlyInterest();
            System.out.printf("\nMês %d: R$%.2f", i, account.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual: ");
        double newAnnualRate = scanner.nextDouble();

        SavingsAccount.setAnnualInterestRate(newAnnualRate);

        System.out.printf("Alterando taxa de juros anual para %.0f%%... ", newAnnualRate);

        account.calculateMonthlyInterest();
        System.out.printf("\nMês 13: R$%.2f", account.getSavingsBalance());

        scanner.close();

    }
}
