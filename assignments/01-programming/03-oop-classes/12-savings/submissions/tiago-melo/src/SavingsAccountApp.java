import java.util.Locale;
import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaJurosAnual = scanner.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxaJurosAnual);

        System.out.println("Saldos com taxa de juros de " + String.format(Locale.US, "%.1f", SavingsAccount.getAnnualInterestRate()) + "%:");
        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", mes, conta.getSavingsBalance());
        }

        System.out.print("Informe a nova taxa de juros anual: ");
        double novaTaxaJurosAnual = scanner.nextDouble();

        SavingsAccount.setAnnualInterestRate(novaTaxaJurosAnual);

        System.out.println();
        System.out.printf("Alterando taxa de juros anual para %.0f%%...%n", SavingsAccount.getAnnualInterestRate());
        System.out.println();

        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());

        scanner.close();
    }
}
