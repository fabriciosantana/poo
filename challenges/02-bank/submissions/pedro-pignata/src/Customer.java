
class Customer{
    private String firstName;
    private String lastName;
    private String cpf;
    private Account accounts;
    
    
    public Customer(String firstName, String lastName, String cpf){
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

    public Account getAccount(){
        return this.accounts;
    }
    
    public void setAccount(Account account){
         this.accounts = account;
    }
    
    public boolean addAccount(Account accounts){
        this.accounts = accounts;
    return true;
    }

    public String displayInformation(){
    return "Nome: " + firstName + " " + lastName + "\n"+
           "CPF: " + cpf + "\n" +
           "Número da Conta: " + accounts.getId() + "\n" +
           "Saldo: R$ " + String.format("%.2f", accounts.getBalance());
    }
}
