class CheckingAccount extends Account {
    private static final double MAINTENANCE_FEE = 10.00;
    private static final double CREDIT_LIMIT = -500.00;

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= CREDIT_LIMIT) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente e sem limite de crédito.");
        }
    }

    public void applyMaintenanceFee() {
        balance -= MAINTENANCE_FEE;
    }
}