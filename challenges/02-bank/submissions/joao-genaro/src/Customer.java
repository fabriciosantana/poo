public class Customer {
    private String firstName;
    private String lastName;
    private String cpf;
    private Account account; 

    public Customer(String firstName, String lastName, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public boolean addAccount(Account account) {
        if (this.account == null) {
            this.account = account;
            return true;
        }
        return false;
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
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    public String displayInformation() {
        String info = "Nome: " + firstName + " " + lastName + "\n" +
                      "CPF: " + cpf + "\n";
        if (account != null) {
            info += "Número da Conta: " + account.getId() + "\n" +
                    "Saldo: " + account.getBalance() + "\n";
        }
        return info;
    }
}