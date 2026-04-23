public class SalaryAccount extends Account {
    @Override
    public void deposit(double amount) {
        throw new UnsupportedOperationException("Conta Salário não permite depósitos manuais.");
    }

    public void depositSalary(double amount) {
        balance += amount;
        addTransaction(new Transaction("DEPÓSITO SALÁRIO", amount));
    }

    @Override
    public String getAccountType() {
        return "Conta Salário";
    }
}
