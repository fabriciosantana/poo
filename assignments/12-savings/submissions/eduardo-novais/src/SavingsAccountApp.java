import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Informe o saldo inicial: ");
        double initialBalance = input.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double annualRate = input.nextDouble();

        SavingsAccount conta1 = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(annualRate);

        System.out.println("\nSaldos com taxa de juros de " + SavingsAccount.getAnnualInterestRate() + "%:");

        for (int i = 1; i <= 12; i++) {
            conta1.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f\n", i, conta1.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual (%): ");
        double newAnnualRate = input.nextDouble();
        
        SavingsAccount.setAnnualInterestRate(newAnnualRate);
        System.out.println("\nAlterando taxa de juros anual para " + SavingsAccount.getAnnualInterestRate() + "%...");
        
        conta1.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f\n", conta1.getSavingsBalance());

        input.close();
    }
}
