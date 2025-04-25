
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public Account getAccount() {
        return account;
    }

    public boolean addAccount(Account account) {
        if (this.account == null) {
            this.account = account;
            return true;
        }
        return false;
    }

    public String displayInformation() {
        return "Nome: " + firstName + " " + lastName + "\n" +
               "CPF: " + cpf + "\n" +
               "Número da Conta: " + (account != null ? account.getId() : "Nenhum") + "\n" +
               "Saldo: " + (account != null ? account.getBalance() : "R$ 0,00");
    }
}
