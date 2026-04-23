import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private String cpf;
    private ArrayList<Account> accounts;

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

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public String displayInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(firstName).append(" ").append(lastName).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Contas:\n");
        for (Account acc : accounts) {
            sb.append("- ").append(acc.getAccountType()).append(" (").append(acc.getId()).append("): ").append(acc.getFormattedBalance()).append("\n");
        }
        return sb.toString();
    }
}
