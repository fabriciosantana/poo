

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class SavingsAccountApp {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Solicita o saldo inicial
            System.out.print("Informe o saldo inicial: ");
            double initialBalance = scanner.nextDouble();

            // 2. Solicita a taxa de juros anual
            System.out.print("Informe a taxa de juros anual (%): ");
            double annualRate = scanner.nextDouble();

            // 3. Cria a conta poupança (o objeto)
            SavingsAccount account = new SavingsAccount(initialBalance);

            // 4. Configura a taxa de juros anual
            SavingsAccount.setAnnualInterestRate(annualRate);

            // 5. Imprime os saldos ao longo de 12 meses
            System.out.printf("\nSaldos com taxa de juros de %.1f%%:\n", SavingsAccount.getAnnualInterestRate());
            for (int month = 1; month <= 12; month++) {
                account.calculateMonthlyInterest();
                System.out.printf("Mês %d: R$%.2f\n", month, account.getSavingsBalance());
            }

            // 6. Solicita a nova taxa de juros
            System.out.print("\nInforme a nova taxa de juros anual (%): ");
            double newAnnualRate = scanner.nextDouble();

            // 7. Atualiza a taxa de juros
            SavingsAccount.setAnnualInterestRate(newAnnualRate);
            System.out.printf("\nAlterando taxa de juros anual para %.1f%%...\n\n", newAnnualRate);

            // 8. Calcula e exibe o saldo do próximo mês
            account.calculateMonthlyInterest();
            System.out.printf("Mês 13: R$%.2f\n", account.getSavingsBalance());

        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Erro: Valor informado inválido. Por favor, utilize números.");
        } finally {
            scanner.close();
        }
    }
}