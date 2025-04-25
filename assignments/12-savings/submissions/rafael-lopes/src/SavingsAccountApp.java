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

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaInicial = scanner.nextDouble();

        SavingsAccount conta = new SavingsAccount(saldoInicial);
        SavingsAccount.setAnnualInterestRate(taxaInicial);

        System.out.printf("Saldos com taxa de juros de %.1f%%%n", SavingsAccount.getAnnualInterestRate());
        for (int i = 1; i <= 12; i++) {
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", i, conta.getSavingsBalance());
        }

        System.out.print("Informe a nova taxa de juros anual: ");
        double novaTaxa = scanner.nextDouble();

        System.out.println("Alterando taxa de juros anual para " + novaTaxa + "%...");
        SavingsAccount.setAnnualInterestRate(novaTaxa);

        conta.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f%n", conta.getSavingsBalance());

        scanner.close();
    }
}
