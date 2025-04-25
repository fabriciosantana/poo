public class CheckingAccount extends Account {
    private static final double MAINTENANCE_FEE = 10.0;
    private static final double CREDIT_LIMIT = -500.0;

    
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction(new Transaction("Depósito", amount));
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= CREDIT_LIMIT) {
            balance -= amount;
         addTransaction(new Transaction("Saque", amount));
         return true;
        }
        return false;
    }

    @Override
    public void applyMonthlyProcessing() {
        balance -= MAINTENANCE_FEE;
        addTransaction(new Transaction("Tarifa mensal", MAINTENANCE_FEE));
    }
    @Override
    public String getType() {
        return "Corrente"; 
    }
}