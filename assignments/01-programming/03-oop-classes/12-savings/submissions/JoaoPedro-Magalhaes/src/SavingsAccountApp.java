import java.util.Scanner;

public class SavingsAccountApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Entrada do saldo inicial
        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = input.nextDouble();

        // Entrada da taxa
        System.out.print("Informe a taxa de juros anual (%): ");
        double taxa = input.nextDouble();

        // Criando conta
        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxa);

        System.out.printf("\nSaldos com taxa de juros de %.1f%%:\n", taxa);

        // 12 meses
        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f\n", mes, conta.getSavingsBalance());
        }

        // Nova taxa
        System.out.print("\nInforme a nova taxa de juros anual: ");
        double novaTaxa = input.nextDouble();

        SavingsAccount.setAnnualInterestRate(novaTaxa);

        System.out.println("\nAlterando taxa de juros anual para " + novaTaxa + "%...\n");

        // Mês 13
        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f\n", conta.getSavingsBalance());

        input.close();
    }
}