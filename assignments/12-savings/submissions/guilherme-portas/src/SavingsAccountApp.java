import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe o saldo inicial: ");
            double saldoInicial = scanner.nextDouble();

            System.out.print("Informe a taxa de juros anual (%): ");
            double taxaJuros = scanner.nextDouble();

            SavingsAccount account = new SavingsAccount(saldoInicial);
            SavingsAccount.setAnnualInterestRate(taxaJuros);

            System.out.printf("Saldos com taxa de juros de %.1f%%\n", taxaJuros);
            int mes;
            for(mes = 1; mes <= 12; mes++) {
                account.calculateMonthlyInterest();
                System.out.printf("Mês %d: R$ %.2f \n", mes, account.getSavingsBalance());
            }

            System.out.print("Informe a nova taxa de juros: ");
            taxaJuros = scanner.nextDouble();

            SavingsAccount.setAnnualInterestRate(taxaJuros);
            System.out.printf("Alterando taxa de juros anual para %f %% \n", account.getAnnualInterestRate());

            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$ %.2f \n", mes, account.getSavingsBalance());
        }
    }
}