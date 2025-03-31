public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.005;

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
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
        balance += balance * INTEREST_RATE;
    }
}