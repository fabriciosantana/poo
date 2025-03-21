public class Custumer {
  private String firstName;
  private String lastName;
  private String cpf;
  private Account accounts;

  public Custumer(String firstName, String lastName, String cpf) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.cpf = cpf;
  }

  public boolean addAccount(Account account){
    this.accounts = account;
    return  true;
  }

  public String displayInformation(){
    return   "Nome: " + this.getFirstName() + " " + this.getLastName() +"\n"
            +"CPF: " + this.getCpf() + "\n"
            +"Número da Conta: " + this.accounts.getId() + "\n"
            +"Saldo : " + this.accounts.getSaldo() + "\n";
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

  
}
