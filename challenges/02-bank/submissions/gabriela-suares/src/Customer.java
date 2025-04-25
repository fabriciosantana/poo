import java.util.ArrayList;
import java.util.List;

class Customer {
    private String firstName;
    private String lastName;
    private String cpf;
    private List<Account> accounts;

    public Customer(String firstName, String lastName, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.accounts = new ArrayList<>();
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public String displayInformation() {
        StringBuilder info = new StringBuilder();
        info.append("Nome: ").append(firstName).append(" ").append(lastName).append("\n")
            .append("CPF: ").append(cpf).append("\n");
        
        if (accounts.isEmpty()) {
            info.append("Nenhuma conta cadastrada.");
        } else {
            for (Account account : accounts) {
                info.append(account.toString()).append("\n");
            }
        }
        return info.toString();
    }
}
