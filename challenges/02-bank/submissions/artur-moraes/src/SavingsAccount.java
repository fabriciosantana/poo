public class SavingsAccount extends Account {
    private final double interestRate = 0.005;

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }
}