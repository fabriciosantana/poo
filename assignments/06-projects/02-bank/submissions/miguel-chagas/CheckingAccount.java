public class CheckingAccount extends Account {
    private final double maintenanceFee = 10.0;
    private final double creditLimit = 500.0;

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance + creditLimit >= amount) {
                balance -= amount;
                addTransaction(new Transaction("SAQUE", amount));
            } else {
                throw new RuntimeException("Saldo insuficiente e sem limite de crédito.");
            }
        }
    }

    public void applyMaintenanceFee() {
        balance -= maintenanceFee;
        addTransaction(new Transaction("TAXA MANUTENÇÃO", maintenanceFee));
    }

    @Override
    public String getAccountType() {
        return "Conta Corrente";
    }
}
