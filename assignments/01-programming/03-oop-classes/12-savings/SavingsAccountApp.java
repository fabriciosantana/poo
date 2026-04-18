import java.util.Scanner;
import java.util.Locale;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaAnual = scanner.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxaAnual);

        System.out.printf(Locale.US, "Saldos com taxa de juros de %.1f%%:\n", taxaAnual);
        for (int i = 1; i <= 12; i++) {
            conta.calculateMonthlyInterest();
            System.out.printf(Locale.US, "Mês %d: R$%.2f\n", i, conta.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual: ");
        String novaTaxaStr = scanner.next();
        novaTaxaStr = novaTaxaStr.replace("%", "");
        double novaTaxa = Double.parseDouble(novaTaxaStr);

        System.out.printf(Locale.US, "\nAlterando taxa de juros anual para %.0f%%...\n\n", novaTaxa);
        SavingsAccount.setAnnualInterestRate(novaTaxa);

        conta.calculateMonthlyInterest();
        System.out.printf(Locale.US, "Mês 13: R$%.2f\n", conta.getSavingsBalance());

        scanner.close();
    }
}
