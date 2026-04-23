import java.util.ArrayList;

public abstract class Account {
    private int id;
    protected double balance;
    private ArrayList<Transaction> transactions;
    private static int accountCounter = 1000;

    public Account() {
        this.id = ++accountCounter;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
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

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            addTransaction(new Transaction("DEPÓSITO", amount));
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
            addTransaction(new Transaction("SAQUE", amount));
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactions;
    }

    public abstract String getAccountType();
}
