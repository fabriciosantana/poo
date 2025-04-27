public abstract class Account {
    private static int accountCounter = 1000;
    private int id;
    protected double balance;

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

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);
    public abstract void applyMonthlyProcessing();

    @Override
    public String toString() {
        return "Número da Conta: " + id + "\n" +
               "Saldo: R$ " + String.format("%.2f", balance);
    }
}