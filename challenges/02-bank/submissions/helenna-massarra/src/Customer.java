class Customer {
    private String firstName;
    private String lastName;
    private String cpf;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;
    private SalaryAccount salaryAccount;

    public Customer(String firstName, String lastName, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public void addAccount(Account account) {
        if (account instanceof CheckingAccount) {
            this.checkingAccount = (CheckingAccount) account;
        } else if (account instanceof SavingsAccount) {
            this.savingsAccount = (SavingsAccount) account;
        } else if (account instanceof SalaryAccount) {
            this.salaryAccount = (SalaryAccount) account;
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String displayInformation() {
        StringBuilder info = new StringBuilder("\nNome: " + firstName + " " + lastName + "\n" +
                                               "CPF: " + cpf + "\n");

        if (checkingAccount != null) {
            info.append("Conta Corrente:\n").append(checkingAccount).append("\n");
        }
        if (savingsAccount != null) {
            info.append("Conta Poupança:\n").append(savingsAccount).append("\n");
        }
        if (salaryAccount != null) {
            info.append("Conta Salário:\n").append(salaryAccount).append("\n");
        }

        return info.toString();
    }

    public Account getAccount(int accountType) {
        switch (accountType) {
            case 1:
                return checkingAccount;
            case 2:
                return savingsAccount;
            case 3:
                return salaryAccount;
            default:
                return null;
        }
    }
}