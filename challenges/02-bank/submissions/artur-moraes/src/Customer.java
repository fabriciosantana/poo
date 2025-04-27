import java.util.ArrayList;
import java.util.List;

public class Customer {
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

    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getCpf() {
        return cpf;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String displayInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(getFullName()).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");
        for (Account account : accounts) {
            sb.append(account.toString()).append("\n");
        }
        return sb.toString();
    }
}
