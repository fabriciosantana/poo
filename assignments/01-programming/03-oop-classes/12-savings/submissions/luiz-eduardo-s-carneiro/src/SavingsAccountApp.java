import java.util.Scanner;

public class SavingsAccountApp{
    public static void main(String[] Args){
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Informe o saldo inicial: ");
        double saldo = scanner.nextDouble();
        SavingsAccount sa = new SavingsAccount(saldo);
        
        System.out.print("Informe a taxa de juros anual (%): ");
        double juros = scanner.nextDouble();
        sa.setAnnualInterestRate(juros);

        for (int i = 1; i <= 12; i++) {
            sa.calculateMonthlyInterest();
            System.out.printf("Mês %d: %.2f\n", i, sa.getSavingsBalance());
        }

        System.out.print("Informe a nova taxa de juros anual: ");
        double newRate = scanner.nextDouble();
        sa.setAnnualInterestRate(newRate);
        
        System.out.printf("Alterando taxa de juros anual para %.2f%%...\n", newRate);
        sa.calculateMonthlyInterest();
        System.out.printf("Mês 13: %.2f\n", sa.getSavingsBalance());
    }
}