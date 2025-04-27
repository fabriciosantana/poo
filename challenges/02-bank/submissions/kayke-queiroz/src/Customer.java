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

    public String getFullName() {
        return firstName + " " + lastName;
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

    public void displayAccounts() {
        System.out.println("Cliente: " + getFullName());
        if (checkingAccount != null) System.out.println("Conta Corrente: " + checkingAccount.getFormattedBalance());
        if (savingsAccount != null) System.out.println("Conta Poupança: " + savingsAccount.getFormattedBalance());
        if (salaryAccount != null) System.out.println("Conta Salário: " + salaryAccount.getFormattedBalance());
    }
}