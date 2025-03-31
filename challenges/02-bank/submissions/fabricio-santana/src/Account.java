public class Account {
    private int id;
    private double balance;
    public static int accountCounter = 999;

    Account(){
        this.id = accountCounter + 1;
        this.balance = 0;
    }

    public int getId() { return this.id; }

    public double getBalance() { return this.balance; }

    public void setBalance(double balance) { this.balance = balance; }

    public double deposit(double amount) {
        return 0.0;
    }

    public double withdraw(double amount) {
        return 0.0;
    }
    
}
