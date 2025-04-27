public class SalaryAccount extends Account {
    @Override
    public void deposit(double amount) {
        System.out.println("Depósitos manuais não são permitidos em contas salário.");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public void applyMonthlyProcessing() {
        // Não há processamento mensal para contas salário
    }
}