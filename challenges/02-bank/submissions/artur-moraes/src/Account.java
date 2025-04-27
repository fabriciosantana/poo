import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private int id;
    private double balance;
    private List<Transaction> transactions;
    private static int accountCounter = 1001;

    public Account() {
        this.id = accountCounter++;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            addTransaction(new Transaction("Depósito", amount));
        }
    }

    public void withdraw(double amount) throws Exception {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            addTransaction(new Transaction("Saque", amount));
        } else {
            throw new Exception("Saldo insuficiente.");
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }

    public String toString() {
        return "Conta " + id + ", Saldo: R$ " + String.format("%.2f", balance);
    }
} 