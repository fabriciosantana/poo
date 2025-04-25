public class SalaryAccount extends Account {
    
    
    @Override
    public void deposit(double amount) {
        System.out.println("Erro: essa conta só recebe depósitos do empregador");
    }

    public boolean withdraw(double amount, double balance) {
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
}


