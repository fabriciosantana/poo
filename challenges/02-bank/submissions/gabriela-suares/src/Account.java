public class Account {
    private static int nextId = 1000;
    private int accountId;
    private double funds;

    public Account() {
        this.accountId = ++nextId;
        this.funds = 0.0;
    }

    public int getAccountId() {
        return accountId;
    }

    public String checkBalance() {
        return String.format("Saldo: R$ %.2f", funds);
    }

    public void addFunds(double value) {
        if (value > 0) {
            this.funds += value;
        } else {
            System.out.println("Depósito inválido.");
        }
    }

    public void removeFunds(double value) {
        if (value > 0 && funds >= value) {
            this.funds -= value;
        } else {
            System.out.println("Saque não permitido.");
        }
    }
}