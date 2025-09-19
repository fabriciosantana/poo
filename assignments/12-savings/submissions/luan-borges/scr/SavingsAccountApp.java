import java.util.Scanner;

public class SavingsAccountApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SavingsAccount account = null;

        try {
            System.out.print("Informe o saldo inicial: ");
            double initialBalance = scanner.nextDouble();

            System.out.print("Informe a taxa de juros anual (%): ");
            double initialRate = scanner.nextDouble();

            account = new SavingsAccount(initialBalance);
            SavingsAccount.setAnnualInterestRate(initialRate);

            System.out.printf("%nSaldos com taxa de juros de %.1f%%:%n", initialRate);

            for (int month = 1; month <= 12; month++) {
                account.calculateMonthlyInterest();
                System.out.printf("Mês %d: R$%.2f%n", month, account.getSavingsBalance());
            }

            System.out.print("\nInforme a nova taxa de juros anual (%): ");
            double newRate = scanner.nextDouble();

            System.out.printf("%nAlterando taxa de juros anual para %.1f%%...%n%n", newRate);
            
            SavingsAccount.setAnnualInterestRate(newRate);

            account.calculateMonthlyInterest();
            System.out.printf("Mês 13: R$%.2f%n", account.getSavingsBalance());

        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado. Verifique os dados de entrada.");
        } finally {
            scanner.close();
        }
    }
}

class SavingsAccount {

    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = this.savingsBalance * (annualInterestRate / 12.0);
        this.savingsBalance += monthlyInterest;
    }

    public static void setAnnualInterestRate(double newRate) {
        if (newRate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = newRate / 100.0;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }
}