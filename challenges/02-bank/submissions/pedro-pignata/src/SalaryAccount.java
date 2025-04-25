public class SalaryAccount extends Account {

    public SalaryAccount(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Depósitos manuais não são permitidos nesta conta.");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= getBalance() && amount > 0) {
            setBalance(getBalance() - amount);
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque.");
            return false;
        }
    }

    public boolean transferTo(Account destination, double amount) {
        if (amount > 0 && getBalance() >= amount) {
            setBalance(getBalance() - amount);
            destination.deposit(amount);
            return true;
        } else {
            System.out.println("Transferência não permitida. Saldo insuficiente.");
            return false;
        }
    }
}
