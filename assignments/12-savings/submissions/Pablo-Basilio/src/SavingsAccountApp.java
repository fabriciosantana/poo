// SavingsAccountApp.java
import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Saldo inicial: ");
        double saldo = sc.nextDouble();

        System.out.print("Taxa anual (%): ");
        double taxa = sc.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldo);
        SavingsAccount.setAnnualInterestRate(taxa);

        System.out.printf("%nSaldos com taxa de %.2f%%%n", taxa);
        for (int i = 1; i <= 12; i++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", i, conta.getSavingsBalance());
        }

        System.out.print("\nNova taxa anual (%): ");
        double novaTaxa = sc.nextDouble();
        SavingsAccount.setAnnualInterestRate(novaTaxa);

        conta.calculateMonthlyInterest();
        System.out.printf("%nMês 13 (com nova taxa %.2f%%): R$%.2f%n",
                novaTaxa, conta.getSavingsBalance());

        sc.close();
    }
}
