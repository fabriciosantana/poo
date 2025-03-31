public class Customer {
    private String firstName;
    private String lastName;
    private String cpf;
    private Account accounts;

    Customer(String firstName, String lastName, String cpf){
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public String getFirstName() {return this.firstName;}

    public void setFirstName(String firstName){ this.firstName = firstName; }

    public String getLastName() { return this.lastName;}

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getCPF() { return this.cpf;}

    public void setCPF(String cpf) { this.cpf = cpf; }

    public Account getAccount() {return this.accounts;}

    public void setAccout(Account account) { this.accounts = account; }

    public boolean addAccount(Account account){
        return true;
    }

    public String displayInformation(){
        return "";
    }
}
