import java.util.Locale;
import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaAnual = scanner.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxaAnual / 100.0); 

        System.out.printf("%nSaldos com taxa de juros de %.1f%%:%n", taxaAnual);

        for (int i = 1; i <= 12; i++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", i, conta.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual: ");
        String entradaTaxa = scanner.next();
        
        entradaTaxa = entradaTaxa.replace("%", ""); 
        double novaTaxa = Double.parseDouble(entradaTaxa);

        System.out.printf("%nAlterando taxa de juros anual para %.0f%%...%n%n", novaTaxa);
        SavingsAccount.setAnnualInterestRate(novaTaxa / 100.0);

        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());

        scanner.close();
    }
}