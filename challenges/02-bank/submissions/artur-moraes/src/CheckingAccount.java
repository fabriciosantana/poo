public class CheckingAccount extends Account {
    private final double maintenanceFee = 10.0;

    @Override
    public void withdraw(double amount) throws Exception {
        if (getBalance() - amount >= -500) {
            super.setBalance(getBalance() - amount);
            addTransaction(new Transaction("Saque", amount));
        } else {
            throw new Exception("Saldo insuficiente e sem limite de crédito.");
        }
    }

    public void applyMaintenanceFee() {
        try {
            withdraw(maintenanceFee);
        } catch (Exception e) {
            System.out.println("Erro ao aplicar taxa: " + e.getMessage());
        }
    }
}