public class SalaryAccount extends Account {
    @Override
    public void deposit(double amount) {
        System.out.println("Depósitos manuais não são permitidos nesta conta.");
    }

    public void transferTo(Account destino, double amount) throws Exception {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            destino.deposit(amount);
            addTransaction(new Transaction("Transferência para conta " + destino.getId(), amount));
        } else {
            throw new Exception("Saldo insuficiente para transferência.");
        }
    }
}
