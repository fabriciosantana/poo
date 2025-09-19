import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pega saldo inicial
        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        // Pega taxa de juros anual
        System.out.print("Informe a taxa de juros anual (%): ");
        double taxa = scanner.nextDouble();

        // Cria conta
        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxa);

        System.out.printf("%nSaldos com taxa de juros de %.1f%%%n", taxa);
        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", mes, conta.getSavingsBalance());
        }

        // Pega nova taxa
        System.out.print("%nInforme a nova taxa de juros anual: ");
        double novaTaxa = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(novaTaxa);

        System.out.printf("%nAlterando taxa de juros anual para %.1f%%%n", novaTaxa);
        conta.calculateMonthlyInterest();
        System.out.printf("%nMês 13: R$%.2f%n", conta.getSavingsBalance());

        scanner.close();
    }
}
