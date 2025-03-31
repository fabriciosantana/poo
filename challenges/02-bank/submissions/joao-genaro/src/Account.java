public class Account {
    private int id;
    private double balance;
    private static int accountCounter = 1000;

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

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Valor de depósito deve ser positivo.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
        }
    }
}