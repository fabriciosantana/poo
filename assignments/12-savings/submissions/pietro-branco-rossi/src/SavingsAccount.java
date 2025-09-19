import java.util.Scanner;
import java.util.InputMismatchException;

public class SavingsAccount {
    private double savingsBalance;

    private static double annualInterestRate;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SavingsAccount account;
        double initialBalance;
        double annualRatePercent;

        while (true) {
            try {
                System.out.print("Informe o saldo inicial: ");
                initialBalance = scanner.nextDouble();
                // ---- Cria uma nova instância da própria classe ---- //
                account = new SavingsAccount(initialBalance);
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                scanner.next(); 
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        
        while (true) {
            try {
                System.out.print("Informe a taxa de juros anual (%): ");
                annualRatePercent = scanner.nextDouble();
                // ---- Define a taxa de juros, convertendo de porcentagem para decimal ---- //
                SavingsAccount.setAnnualInterestRate(annualRatePercent / 100.0);
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                scanner.next(); 
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        // ---- Exibe o cabeçalho do relatório de rendimentos ---- //
        System.out.printf("\nSaldos com taxa de juros de %.1f%%:\n", annualRatePercent);
        
        for (int i = 1; i <= 12; i++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f\n", i, account.getSavingsBalance());
        }

        double newRatePercent;
        while (true) {
            try {
                System.out.print("\nInforme a nova taxa de juros anual (%): ");
                newRatePercent = scanner.nextDouble();
                System.out.printf("\nAlterando taxa de juros anual para %.1f%%...\n\n", newRatePercent);
                // ---- Atualiza a taxa de juros estática ---- //
                SavingsAccount.setAnnualInterestRate(newRatePercent / 100.0);
                break; // Encerra o loop se a entrada for válida
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                scanner.next(); 
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        
        // ---- Calcula e exibe o saldo para o 13º mês com a nova taxa ---- //
        account.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f\n", account.getSavingsBalance());

        scanner.close();
    }

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = (this.savingsBalance * annualInterestRate) / 12.0;
        
        this.savingsBalance += monthlyInterest;
    }

    // ---- Modifica a taxa de juros anual para todas as contas ---- //
    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate;
    }

    // ---- Retorna o saldo atual da conta ---- //
    public double getSavingsBalance() {
        return this.savingsBalance;
    }
}


