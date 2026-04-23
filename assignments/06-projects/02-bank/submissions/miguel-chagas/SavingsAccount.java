public class SavingsAccount extends Account {
    private final double interestRate = 0.005;

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        addTransaction(new Transaction("RENDIMENTO", interest));
    }

    @Override
    public String getAccountType() {
        return "Conta Poupança";
    }
}
