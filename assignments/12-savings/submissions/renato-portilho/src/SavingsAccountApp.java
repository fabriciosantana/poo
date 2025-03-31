import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o saldo inicial da conta: ");
        double initialBalance = scanner.nextDouble();

        System.out.print("Digite a taxa de juros anual (em decimal, por exemplo, 0.05 para 5%): ");
        double annualInterestRate = scanner.nextDouble();

        SavingsAccount myAccount = new SavingsAccount(initialBalance);

        SavingsAccount.setAnnualInterestRate(annualInterestRate);

        System.out.println("\nSaldos após cada mês com a taxa de juros inicial:");
        for (int i = 1; i <= 12; i++) {
            myAccount.calculateMonthlyInterest();
            System.out.printf("Mês %d: Saldo = R$ %.2f\n", i, myAccount.getSavingsBalance());
        }

        System.out.print("\nDigite a nova taxa de juros anual (em decimal): ");
        double newAnnualInterestRate = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(newAnnualInterestRate);

        myAccount.calculateMonthlyInterest();
        System.out.printf("\nSaldo após o 13º mês com a nova taxa de juros: R$ %.2f\n", myAccount.getSavingsBalance());

        scanner.close();
    }
}
