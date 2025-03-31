

public class Customer {

    private String firstName;
    private String lastName;
    private String CPF;
    private Account accounts;

    public Customer(String firstName, String lastName, String CPF){
        this.CPF = CPF;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = null;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public Account getAccount() {
        return accounts;
    }

    public void setAccount(Account account) {
        this.accounts = account;
    }

    
public boolean addAccount(Account account){
    if(this.accounts == null){
        this.accounts = accounts;
        return true;

    }else{
        return false;
    }

}

public String displayInformation(){
    return "Primeiro Nome: "+firstName+"\n" +
    "Sobrenome: "+lastName+ "\n"+
    "CPF: "+CPF;

}
    
}
