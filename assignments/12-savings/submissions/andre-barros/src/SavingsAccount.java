import java.util.Scanner;

public class SavingsAccount {
    private double savingsBalance;            // saldo da conta
    private static double annualInterestRate; // taxa anual de juros (fração, ex: 0.04 para 4%)

    // Construtor
    public SavingsAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo!");
        }
        this.savingsBalance = initialBalance;
    }

    // Calcula juros mensal e adiciona ao saldo
    public void calculateMonthlyInterest() {
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12.0;
        savingsBalance += monthlyInterest;
    }

    // Retorna saldo atual
    public double getSavingsBalance() {
        return savingsBalance;
    }

    // Define taxa anual de juros
    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("Taxa de juros não pode ser negativa!");
        }
        annualInterestRate = rate;
    }

    // Método principal para testar
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Lê saldo inicial
        System.out.print("Informe o saldo inicial: ");
        double initialBalance = input.nextDouble();

        // Lê taxa de juros anual
        System.out.print("Informe a taxa de juros anual (%): ");
        double annualRate = input.nextDouble();

        // Cria conta e define taxa
        SavingsAccount account = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(annualRate / 100.0); // converter para fração

        // Exibe saldos para 12 meses
        System.out.printf("%nSaldos com taxa de %.2f%%%n", annualRate);
        for (int mes = 1; mes <= 12; mes++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", mes, account.getSavingsBalance());
        }

        // Lê nova taxa após 12 meses
        System.out.print("\nInforme a nova taxa de juros anual (%): ");
        double newRate = input.nextDouble();
        SavingsAccount.setAnnualInterestRate(newRate / 100.0);

        // Calcula mês 13 com nova taxa
        account.calculateMonthlyInterest();
        System.out.printf("%nSaldo após 13º mês com taxa %.2f%%: R$%.2f%n",
                newRate, account.getSavingsBalance());

        input.close();
    }
}
