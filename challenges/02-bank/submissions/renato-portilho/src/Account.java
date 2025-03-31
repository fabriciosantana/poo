
import java.text.DecimalFormat;

public class Account {
    private int id;
    private double balance;
    private double amount;
    private static int accountCounter;

    public Account() {
        this.id = ++accountCounter; // gera o id da conta
        this.balance = 0.00;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBalance() { // formatando o saldo
        DecimalFormat df = new DecimalFormat("R$ 0.00");
        return df.format(balance);
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("O saldo não pode ser negativo");
        }

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Depósito de " + getBalance() + " feito com sucesso");
        } else {
            System.out.println("O valor do depósito deve ser positivo");
        }

    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Saque de " + getBalance() + " realizado com sucesso.");
            return true;
        } else if (amount < 0) {
            System.out.println("Valor inválido");

        } else {
            System.out.println("Saldo insuficiente");
        }
        return false;
    }

    public static int getAccountCounter() {
        return accountCounter;
    }

}
