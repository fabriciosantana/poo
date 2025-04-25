
import java.text.DecimalFormat;

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
        DecimalFormat df = new DecimalFormat("R$ #,##0.00");
        return df.format(balance);
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
