public class SavingsAccount {
    
}public class SavingsAccount {
    
    private double savingsBalance;
    private static double annualInterestRate;

    // Construtor
    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    // Calcula os juros mensais e adiciona ao saldo
    public void calculateMonthlyInterest() {
        /*
         * FÓRMULA DO ENUNCIADO: 
         * double taxaMensal = Math.pow(1 + annualInterestRate, 1.0 / 12.0) - 1;
         * * FÓRMULA DO DEITEL (que gera o resultado exato do seu exemplo):
         */
        double taxaMensal = annualInterestRate / 12.0;
        
        double juros = this.savingsBalance * taxaMensal;
        this.savingsBalance += juros;
    }

    // Getter para a taxa de juros
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // Setter para a taxa de juros
    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate;
    }

    // Recupera o saldo da conta
    public double getSavingsBalance() {
        return this.savingsBalance;
    }
}
