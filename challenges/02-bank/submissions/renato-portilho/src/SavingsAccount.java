public class SavingsAccount extends Account {
    private static double interestRate = 0.005;
    
    public void applyInterest(double interestRate){


        setBalance(getBalance() * interestRate);
    }

}
