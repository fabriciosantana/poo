public class Account {
    private int id;
    private double balance;
    public static int accountCounter;

    public Account(int id) {
        this.id = id;
        balance = 0;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance() {
        if(balance < 0) balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
