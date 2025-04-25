public class CheckingAccount extends Account {
    private static final double maintenanceFee = 10.0;
    private static final double creditLimit = 500.0;

    public CheckingAccount(double balance) {
        super(balance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;

        if (getBalance() - amount >= -creditLimit) {
            setBalance(getBalance() - amount);
            return true;
        } else {
            throw new RuntimeException("Saldo insuficiente e sem limite de crédito.");
        }
    }

    public void applyMaintenanceFee() {
        setBalance(getBalance() - maintenanceFee);
    }
}
