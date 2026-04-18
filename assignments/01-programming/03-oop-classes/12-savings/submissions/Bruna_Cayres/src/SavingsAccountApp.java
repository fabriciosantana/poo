import java.util.Scanner;

public class SavingsAccountApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicita dados iniciais
            System.out.print("Informe o saldo inicial: ");
            double saldoInicial = scanner.nextDouble();

            System.out.print("Informe a taxa de juros anual (%): ");
            double taxaAnual = scanner.nextDouble();

            // Cria a conta e configura a taxa
            // Dividimos por 100 para transformar a porcentagem (ex: 4) em decimal (0.04)
            SavingsAccount conta = new SavingsAccount(saldoInicial);
            SavingsAccount.setAnnualInterestRate(taxaAnual / 100.0);

            // Imprime os 12 primeiros meses
            System.out.printf("%nSaldos com taxa de juros de %.1f%%:%n", taxaAnual);
            for (int mes = 1; mes <= 12; mes++) {
                conta.calculateMonthlyInterest();
                System.out.printf("Mês %d: R$%.2f%n", mes, conta.getSavingsBalance());
            }

            // Solicita a atualização da taxa
            System.out.print("\nInforme a nova taxa de juros anual (%): ");
            double novaTaxa = scanner.nextDouble();

            System.out.printf("Alterando taxa de juros anual para %.0f%%...%n%n", novaTaxa);
            SavingsAccount.setAnnualInterestRate(novaTaxa / 100.0);

            // Calcula e imprime o Mês 13 com a nova taxa
            conta.calculateMonthlyInterest();
            System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

}
