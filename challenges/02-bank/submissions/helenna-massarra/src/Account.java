
import java.util.ArrayList;

public abstract class Account {
    private static int accountCounter = 1000;
    private String type;
    private int id;
    protected double balance;
    protected ArrayList<Transaction> transactions;

    public Account() {
        this.id = ++accountCounter;
        this.balance = 0.0;
        this.type = type;
        this.transactions = new ArrayList<>();
    }
public abstract String getType();
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactions;
    }

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);
    public abstract void applyMonthlyProcessing();

    @Override
    public String toString() {
        return "Número da Conta: " + id + "\n" +
               "Tipo: " + type + "\n" +
               "Saldo: R$ " + String.format("%.2f", balance);
    }
}