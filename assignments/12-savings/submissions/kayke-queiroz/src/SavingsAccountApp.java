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

    public static void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void calculateMonthlyInterest() {
        double monthlyRate = Math.pow(1 + (annualInterestRate / 100.0), 1.0 / 12) - 1;
        savingsBalance += savingsBalance * monthlyRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita saldo inicial
        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();

        // Validação da taxa de juros
        double initialInterestRate;
        do {
            System.out.print("Informe a taxa de juros anual (%): ");
            initialInterestRate = scanner.nextDouble();
            if (initialInterestRate < 0) {
                System.out.println("Erro: A taxa de juros não pode ser negativa. Tente novamente.");
            }
        } while (initialInterestRate < 0);

        // Criar conta
        SavingsAccount account = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(initialInterestRate);

        System.out.printf("\nSaldos com taxa de juros de %.2f%%:%n", initialInterestRate);
        for (int i = 1; i <= 12; i++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", i, account.getSavingsBalance());
        }

        // Solicita nova taxa de juros
        double newInterestRate;
        do {
            System.out.print("\nInforme a nova taxa de juros anual (%): ");
            newInterestRate = scanner.nextDouble();
            if (newInterestRate < 0) {
                System.out.println("Erro: A taxa de juros não pode ser negativa. Tente novamente.");
            }
        } while (newInterestRate < 0);

        SavingsAccount.setAnnualInterestRate(newInterestRate);

        System.out.printf("\nAlterando taxa de juros anual para %.2f%%...%n", newInterestRate);
        account.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", account.getSavingsBalance());

        scanner.close();
    }
}
