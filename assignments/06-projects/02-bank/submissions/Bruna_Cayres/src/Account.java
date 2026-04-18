public class Account {
    private static int accountCounter = 1000;

    private int id;
    private double balance;

    public Account() {
        this.id = ++accountCounter;
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getBalance() {
        return String.format("R$ %.2f", balance);
    }

    double getBalanceValue() {
        return balance;
    }

    public void setBalance(double amount) {
        if (amount < 0) {
            
            return;
        }
        this.balance = amount;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        if (amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public static int getAccountCounter() {
        return accountCounter;
    }
}
