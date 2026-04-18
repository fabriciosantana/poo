import java.util.Scanner;

public class SavingsAccountApp{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double savingsBalance = scanner.nextDouble();
        System.out.print("Informe a taxa de juros anual: ");
        double annualInterestRate = scanner.nextDouble();

        SavingsAccount Account = new SavingsAccount(savingsBalance);
        SavingsAccount.setAnnualInterestRate(annualInterestRate);
        
        System.out.printf("Saldos com taxa de juros de %.1f%% %n", annualInterestRate);
        for (int i = 0; i<12; i++){
            Account.calculateMonthlyInterest();
            System.out.printf("Mês %d: $%.2f %n", (i+1), Account.getSavingsBalance());
        }

        System.out.print("Informe a nova taxa de juros anual: ");
        annualInterestRate = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(annualInterestRate);
        Account.calculateMonthlyInterest();

        System.out.printf("Alterando taxa de juros anual para %.1f%% %n",annualInterestRate);
        System.out.printf("Mês 13: $%.2f %n", Account.getSavingsBalance());

        scanner.close();

    }

}