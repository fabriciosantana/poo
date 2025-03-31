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

    public void calculateMonthlyInterest() {
        double monthlyRate = Math.pow(1 + annualInterestRate / 100, 1.0 / 12) - 1;
        savingsBalance += savingsBalance * monthlyRate;
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
        
        // Solicita saldo inicial
        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        
        // Solicita taxa de juros
        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaJuros = scanner.nextDouble();
        
        // Cria conta e define taxa de juros
        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxaJuros);
        
        System.out.println("\nSaldos com taxa de juros de " + taxaJuros + "%:");
        for (int mes = 1; mes <= 12; mes++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", mes, conta.getSavingsBalance());
        }
        
        // Solicita nova taxa de juros
        System.out.print("\nInforme a nova taxa de juros anual (%): ");
        double novaTaxaJuros = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(novaTaxaJuros);
        
        // Calcula e exibe saldo com nova taxa
        System.out.println("\nAlterando taxa de juros anual para " + novaTaxaJuros + "%...\n");
        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());
        
        scanner.close();
    }
}
