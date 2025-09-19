public class SavingsAccount {
    private double savingsBalance; // saldo da conta
    private static double annualInterestRate; // taxa de juros anual

    // Construtor
    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    // Calcula juros mensais e adiciona ao saldo
    public void calculateMonthlyInterest() {
        double monthlyRate = Math.pow(1 + annualInterestRate, 1.0 / 12.0) - 1;
        double interest = savingsBalance * monthlyRate;
        savingsBalance += interest;
    }

    // Getter para saldo
    public double getSavingsBalance() {
        return savingsBalance;
    }

    // Getter taxa de juros
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // Setter taxa de juros
    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate / 100.0; // converte % para decimal
    }
}

