import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double annualRate = scanner.nextDouble();

        SavingsAccount account = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(annualRate);

        System.out.printf("Saldos com taxa de juros de %.1f%%:%n", annualRate);
        for (int month = 1; month <= 12; month++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", month, account.getSavingsBalance());
        }

        
        System.out.print("Informe a nova taxa de juros anual: ");
        String newRateStr = scanner.next().replace("%", "");
        double newAnnualRate = Double.parseDouble(newRateStr);

        System.out.printf("%nAlterando taxa de juros anual para %.0f%%...%n%n", newAnnualRate);
        SavingsAccount.setAnnualInterestRate(newAnnualRate);

        account.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", account.getSavingsBalance());

        scanner.close();
    }
}