public class Account {
    private int id = 0;
    private double balance;
    private static int accountCounter = 0;

    public Account(Customer customer) {
        accountCounter++;
        this.id = accountCounter;
        this.balance = 0.0;
    }

    public int getId() {return this.id;}
    public double getBalance() {return this.balance;}
    public static int getAccountCounter() {return accountCounter;}

    public void setBalance(double balance) {this.balance = balance;}

    public double deposit(double amount) {
        this.balance += amount;
        return this.balance;
    }

    public double withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Saldo Insuficiente!");
            return this.balance;
        } else {
            this.balance -= amount;
            return this.balance;
        }
    }
}
