public class SavingsAccount extends Account {
    private static final double interestRate = 0.005; // 0,5%

    public SavingsAccount(double balance) {
        super(balance);
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
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
}
