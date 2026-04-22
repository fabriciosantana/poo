public class Customer {
    private String firstName;
    private String lastName;
    private String CPF;
    private Account account;

    public Customer(String firstName, String lastName, String CPF) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CPF = CPF;
    }

    public String getFirstName() {return this.firstName;}
    public String getLastName() {return this.lastName;}
    public String getCPF() {return this.CPF;}
    public Account getAccount() {return this.account;}

    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setCPF(String CPF) {this.CPF = CPF;}
    public void setAccount(Account account) {this.account = account;}

    public boolean addAccount(Account account) {
        return true;
    }

    public String displayInformation(){
        return  "Nome: " + this.firstName + " " + this.lastName + "\n" +
                "CPF: " + this.CPF + "\n" +
                "Numero da conta: " + (this.account != null ? this.account.getId() : "No account") + "\n" +
                "Account Balance: R$ " + (this.account != null ? this.account.getBalance() : "No account");
    }

}
