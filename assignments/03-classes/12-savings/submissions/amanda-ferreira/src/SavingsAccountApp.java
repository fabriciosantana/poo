import java.util.Scanner;

public class SavingsAccountApp{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o saldo inicial: ");
        double saldo = scanner.nextDouble();
        System.out.print("Informe a taxa de juros anual (%): ");
        double taxa = scanner.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldo);
        SavingsAccount.setAnnualInterestRate(taxa);

        System.out.printf("Saldos com taxa de juros de %.1f%%:\n", taxa);
        for(int i = 1; i <= 12; i++){
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d:  R$%.2f\n", i, conta.getSavingsBalance());
        }

        System.out.print("Informe a nova taxa de juros anual: ");
        double novaTaxa = scanner.nextDouble();

        System.out.printf("\nAlterando taxa de juros anual para %.0f%%...\n\n", novaTaxa);
        SavingsAccount.setAnnualInterestRate(novaTaxa);

        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f\n", conta.getSavingsBalance());
        scanner.close();
    }
}