import java.util.Scanner;

public class SavingsAccount {
    private double savingsBalance;            // saldo da conta
    private static double annualInterestRate; // taxa anual de juros (fração: 0.04 = 4%)

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

    // Define taxa anual de juros (recebe em FRAÇÃO, ex: 0.04 = 4%)
    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("Taxa de juros não pode ser negativa!");
        }
        annualInterestRate = rate;
    }

    // Método principal de teste
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double initialBalance = input.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double annualRate = input.nextDouble();

        // Criar conta e definir taxa (converter para fração!)
        SavingsAccount account = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(annualRate / 100.0);

        System.out.printf("%nSaldos com taxa de %.2f%%%n", annualRate);
        for (int mes = 1; mes <= 12; mes++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f%n", mes, account.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual (%): ");
        double newRate = input.nextDouble();
        SavingsAccount.setAnnualInterestRate(newRate / 100.0);

        account.calculateMonthlyInterest();
        System.out.printf("%nSaldo após 13º mês com taxa %.2f%%: R$%.2f%n",
                newRate, account.getSavingsBalance());

        input.close();
    }
}



