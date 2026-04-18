public class Customer {
    private String firstName;
    private String lastName;
    private String cpf;
    private Account accounts;

    public Customer(String firstName, String lastName, String cpf) {
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

    public Account getAccounts() {
        return accounts;
    }

    public void setAccounts(Account accounts) {
        this.accounts = accounts;
    }

    public boolean addAccount(Account account) {
        if (this.accounts != null) {
            return false; 
        }
        this.accounts = account;
        return true;
    }

    public String displayInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(firstName).append(" ").append(lastName).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");
        if (accounts != null) {
            sb.append("Número da Conta: ").append(accounts.getId()).append("\n");
            sb.append("Saldo: ").append(accounts.getBalance()).append("\n");
        }
        return sb.toString();
    }
}
