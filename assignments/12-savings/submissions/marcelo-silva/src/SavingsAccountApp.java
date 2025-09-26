import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class SavingsAccountApp {

    public static void main(String[] args) {
        // Define o Locale para pt-BR para formatar a saída como moeda brasileira (R$)
        Locale localeBrasil = Locale.of("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeBrasil);
        Scanner scanner = new Scanner(System.in);
        // Garante que o scanner use ponto como separador decimal para a entrada
        scanner.useLocale(Locale.US);

        try {
            // --- Entrada de Dados Iniciais ---
            System.out.print("Informe o saldo inicial: ");
            double initialBalance = scanner.nextDouble();

            System.out.print("Informe a taxa de juros anual (%): ");
            double annualRatePercent = scanner.nextDouble();

            // --- Criação do Objeto e Definição da Taxa ---
            SavingsAccount account = new SavingsAccount(initialBalance);
            // Converte a taxa de porcentagem para decimal (ex: 4 -> 0.04)
            SavingsAccount.setAnnualInterestRate(annualRatePercent / 100.0);

            // --- Cálculo dos Primeiros 12 Meses ---
            System.out.printf("%nSaldos com taxa de juros de %.1f%%:%n", annualRatePercent);
            for (int month = 1; month <= 12; month++) {
                account.calculateMonthlyInterest();
                System.out.printf("Mês %d: %s%n", month, currencyFormatter.format(account.getSavingsBalance()));
            }

            // --- Atualização da Taxa de Juros ---
            System.out.printf("%nInforme a nova taxa de juros anual (%%): ");
            double newAnnualRatePercent = scanner.nextDouble();
            
            System.out.printf("%nAlterando taxa de juros anual para %.1f%%...%n%n", newAnnualRatePercent);
            SavingsAccount.setAnnualInterestRate(newAnnualRatePercent / 100.0);

            // --- Cálculo do 13º Mês com a Nova Taxa ---
            account.calculateMonthlyInterest();
            System.out.printf("Mês 13: %s%n", currencyFormatter.format(account.getSavingsBalance()));

        } catch (IllegalArgumentException e) {
            // Captura exceções de validação da classe SavingsAccount
            System.err.println("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            // Captura erro se o usuário digitar um texto em vez de um número
            System.err.println("Erro de entrada: Por favor, insira um valor numérico válido.");
        } finally {
            // Garante que o scanner seja fechado, mesmo que ocorra um erro
            scanner.close();
        }
    }
}