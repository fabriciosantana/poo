// Nome: Allan Samuel Alves do Monte
// Matrícula: 24101279

import java.util.Scanner;

class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {        // Função corrigida.
        double monthlyRate = (annualInterestRate / 100) / 12;  
        savingsBalance *= (1 + monthlyRate);
    }

    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Informe a taxa de juros anual (%): ");
        double initialRate = readPercentage(scanner);
        
        SavingsAccount account = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(initialRate);
        
        System.out.printf("Saldos com taxa de juros de %.1f%%:%n", initialRate);
        for (int i = 1; i <= 12; i++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", i, account.getSavingsBalance());
        }
        
        System.out.print("Informe a nova taxa de juros anual: ");
        double newRate = readPercentage(scanner);
        SavingsAccount.setAnnualInterestRate(newRate);
        
        System.out.printf("\nAlterando taxa de juros anual para %.1f%%...%n", newRate);
        account.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", account.getSavingsBalance());
        
        scanner.close();
    }

    private static double readPercentage(Scanner scanner) {
        String input = scanner.nextLine().trim();
        if (input.endsWith("%")) {
            input = input.substring(0, input.length() - 1).trim(); // para não dar problema no % da entrada, remove ele.
        }
        return Double.parseDouble(input);
    }
}
