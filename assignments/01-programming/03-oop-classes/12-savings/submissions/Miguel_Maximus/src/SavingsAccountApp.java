import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Informe o saldo inicial: ");
            double saldoInicial = scanner.nextDouble();

            System.out.print("Informe a taxa de juros anual (%): ");
            double taxaInicial = scanner.nextDouble();

            SavingsAccount account = new SavingsAccount(saldoInicial);
            SavingsAccount.setAnnualInterestRate(taxaInicial);

            System.out.printf("%nSaldos com taxa de juros de %.1f%%%n", SavingsAccount.getAnnualInterestRate());
            for (int mes = 1; mes <= 12; mes++) {
                account.calculateMonthlyInterest();
                System.out.printf("Mês %d: R$%.2f%n", mes, account.getSavingsBalance());
            }

            System.out.print("%nInforme a nova taxa de juros anual (%): ");
            double novaTaxa = scanner.nextDouble();

            SavingsAccount.setAnnualInterestRate(novaTaxa);

            System.out.printf("%nAlterando taxa de juros anual para %.1f%%%n%n", SavingsAccount.getAnnualInterestRate());

            account.calculateMonthlyInterest();
            System.out.printf("Mês 13: R$%.2f%n", account.getSavingsBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}