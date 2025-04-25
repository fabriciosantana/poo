public class SalaryAccount {
    @Override
    public void deposit(double amount) {
        throw new UnsupportedOperationException("Depósitos manuais não são permitidos nesta conta.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }
}
