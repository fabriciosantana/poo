class Account {
    private int id;
    private double balance;
    private static int accountCounter = 0;

    public Account(double balancem){
        this.balance = 0.0;
        this.id = ++accountCounter;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(){
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("O valor do depósito deve ser positivo.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

/*

public class Account{
    private int id = 999
    private double balance;

    Account(){
        this.id += 1
        this.balance = 0
    }

    public int getId(){
        return this.id;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double balance){
    return
    }
}
 */