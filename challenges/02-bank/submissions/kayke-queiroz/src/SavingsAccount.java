class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.005; // 0,5% ao mês

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    public void applyInterest() {
        balance += balance * INTEREST_RATE;
    }
}