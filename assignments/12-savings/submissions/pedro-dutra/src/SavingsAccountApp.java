import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaAnual = scanner.nextDouble();

        SavingsAccount minhaConta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxaAnual);

        System.out.printf("\nSaldos com taxa de juros de %.1f%%:\n", taxaAnual);
        for (int i = 1; i <= 12; i++) {
            minhaConta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f\n", i, minhaConta.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual: ");
        double novaTaxaAnual = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(novaTaxaAnual);

        System.out.printf("\nAlterando taxa de juros anual para %.1f%%...\n", novaTaxaAnual);
        minhaConta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f\n", minhaConta.getSavingsBalance());

        scanner.close();
    }
}
