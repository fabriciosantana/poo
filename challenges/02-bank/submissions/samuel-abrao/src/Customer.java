public class Customer{
   private String firstName;
   private String lastName;
   private String cpf;
   private Account account;

   public Customer(String firstName, String lastName, String cpf){
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.account = null; 
   }

   public String getFirstName(){
        return firstName;
   }

   public void setFirstName(String firstName){
        this.firstName = firstName;
   }

   public String getLastname(){
        return lastName;
   }

   public void setLastName(String lastName){
        this.lastName = lastName;
   }

   public String getCpf(){
        return cpf;
   }

   public void setCpf(String cpf){
        this.cpf = cpf;
   }

   public String getAccount(){
        return account;
   }

   public void setAccount(String account){
        f(this.account == null) {
            this.account = account;
            return true;
        }
        return false;
   }

   public String displayInformation() {
        String info = "Nome: " + firstName + " " + lastName + "\n" +
                      "CPF: " + cpf + "\n";
        if(account != null) {
            info += "Número da Conta: " + account.getId() + "\n" +
                    "Saldo: " + account.getFormattedBalance() + "\n";
        }
        return info;
    }
    
}