public abstract class Account {
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

class CheckingAccount extends Account {

    public CheckingAccount(Customer customer) {
        super(customer);
        // Saques, depósitos e taxa mensal de manutenção
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(Customer customer){
        super(customer);
        // Conta que rende juros mensalmente sobre saldo disponível
    }
}

class SalaryAccount extends Account {
    public SalaryAccount(Customer customer) {
        super(customer);
        // Conta para recebimento de salário
        // Apenas saques e transferências para outra conta
    }
}
