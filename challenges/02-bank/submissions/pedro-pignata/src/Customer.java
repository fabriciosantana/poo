
class Customer{
    private String firstName;
    private String lastName;
    private String cpf;

    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;
    private SalaryAccount salaryAccount;
     
    public Customer(String firstName, String lastName, String cpf){
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }
    
    public String getFirstName() {
        return firstName;
    }    
       
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public SalaryAccount getSalaryAccount() {
        return salaryAccount;
    }

    public boolean addAccount(Account account) {
        if (account instanceof CheckingAccount && checkingAccount == null) {
            checkingAccount = (CheckingAccount) account;
            return true;
        } else if (account instanceof SavingsAccount && savingsAccount == null) {
            savingsAccount = (SavingsAccount) account;
            return true;
        } else if (account instanceof SalaryAccount && salaryAccount == null) {
            salaryAccount = (SalaryAccount) account;
            return true;
        }
        return false;
    }

    public String displayAccounts() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contas cadastradas para ").append(firstName).append(" ").append(lastName).append(":\n");

        if (checkingAccount != null)
            sb.append("1. Conta Corrente - Nº ").append(checkingAccount.getId())
              .append(" | Saldo: R$ ").append(String.format("%.2f", checkingAccount.getBalance())).append("\n");

        if (savingsAccount != null)
            sb.append("2. Conta Poupança - Nº ").append(savingsAccount.getId())
              .append(" | Saldo: R$ ").append(String.format("%.2f", savingsAccount.getBalance())).append("\n");

        if (salaryAccount != null)
            sb.append("3. Conta Salário - Nº ").append(salaryAccount.getId())
              .append(" | Saldo: R$ ").append(String.format("%.2f", salaryAccount.getBalance())).append("\n");

        return sb.toString();
    }

    public String displayInformation() {
        return "Nome: " + firstName + " " + lastName + "\n" +
               "CPF: " + cpf + "\n" +
               displayAccounts();
    }
}