import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o saldo inicial ao usuário
        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        SavingsAccount conta = new SavingsAccount(saldoInicial); // Cria uma nova conta com o saldo informado

        // Solicita a taxa de juros anual ao usuário
        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaJuros = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(taxaJuros); // Define a taxa de juros para todas as contas

        // Exibe os saldos ao longo de 12 meses
        System.out.println("\nSaldos com taxa de juros de " + taxaJuros + "%:");
        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest(); // Calcula os juros do mês atual
            System.out.printf("Mês %d: R$%.2f%n", mes, conta.getSavingsBalance());
        }

        // Solicita uma nova taxa de juros anual após 12 meses
        System.out.print("\nInforme a nova taxa de juros anual: ");
        taxaJuros = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(taxaJuros); // Atualiza a taxa de juros

        // Calcula e exibe o saldo do mês 13 com a nova taxa de juros
        System.out.println("\nAlterando taxa de juros anual para " + taxaJuros + "%...");
        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());

        scanner.close(); // Fecha o scanner
    }
}
