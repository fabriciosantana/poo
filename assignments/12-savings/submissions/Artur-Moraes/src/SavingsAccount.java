public class SavingsAccount {
    private double savingsBalance; // Saldo atual da conta
    private static double annualInterestRate; // Taxa de juros anual para todas as contas

    // Construtor que inicializa o saldo da conta
    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    // Método estático para definir a taxa de juros anual
    public static void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    // Método estático para obter a taxa de juros anual atual
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // Método para obter o saldo atual da conta
    public double getSavingsBalance() {
        return savingsBalance;
    }

    // Método que calcula e aplica os juros mensais ao saldo da conta
    public void calculateMonthlyInterest() {
        double monthlyRate = Math.pow(1 + annualInterestRate / 100, 1.0 / 12) - 1; // Fórmula da taxa mensal
        double monthlyInterest = savingsBalance * monthlyRate; // Juros calculados para o mês
        savingsBalance += monthlyInterest; // Atualiza o saldo com os juros mensais
    }
}
