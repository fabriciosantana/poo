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
        if (account == null) {
            return false;
        }
        this.accounts = account;
        return true;
    }

    public String displayInformation() {
        String fullName = firstName + " " + lastName;
        if (accounts == null) {
            return "Nome: " + fullName + "\n"
                + "CPF: " + cpf + "\n"
                + "Conta: não cadastrada";
        }

        return "Nome: " + fullName + "\n"
            + "CPF: " + cpf + "\n"
            + "Número da Conta: " + accounts.getId() + "\n"
            + "Saldo: " + accounts.getBalance();
    }
}
