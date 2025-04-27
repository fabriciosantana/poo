abstract class Account {
    protected int id;
    protected double balance;
    private static int accountCounter = 1000;

    public Account() {
        this.id = ++accountCounter;
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getFormattedBalance() {
        return String.format("R$ %.2f", balance);
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    }