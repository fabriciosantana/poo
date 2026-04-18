import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = input.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaInicial = input.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxaInicial);

        System.out.printf("\nSaldos com taxa de juros de %.1f%%:\n", SavingsAccount.getAnnualInterestRate());

        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f\n", mes, conta.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual: ");
        double novaTaxa = input.nextDouble();

        SavingsAccount.setAnnualInterestRate(novaTaxa);

        System.out.println("\nAlterando taxa de juros anual para " + novaTaxa + "%...\n");

        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f\n", conta.getSavingsBalance());

        input.close();
    }
}