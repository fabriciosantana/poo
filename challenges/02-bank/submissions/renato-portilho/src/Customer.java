

public class Customer {

    private String firstName;
    private String lastName;
    private String CPF;
    private Account accounts;

    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;
    private SalaryAccount salaryAccount;

    public Customer(String firstName, String lastName, String CPF){
        this.CPF = CPF;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = null;
    }

    public boolean addAccount(Account account){
        if(account instanceof CheckingAccount){
            if(this.checkingAccount == null){
            this.checkingAccount = (CheckingAccount) account; 
            return true; 
            }
        }

        if(account instanceof SavingsAccount){
            if(this.savingsAccount == null){
                this.savingsAccount = (SavingsAccount) account;
                return true;

            }
        }

        if(account instanceof SalaryAccount){
            if(this.salaryAccount == null){
                this.salaryAccount = (SalaryAccount) account;
                return true;
            }
        }
        return false;

    }

    public void displayAccounts(){
        System.out.println("Contas de " +firstName+ " " +lastName);
        if(checkingAccount != null){
        System.out.println("Conta corrente: " +checkingAccount.getId());
        }
        if(savingsAccount != null){
        System.out.println("Conta poupança: " +savingsAccount.getId());
        }
        if(salaryAccount != null){
        System.out.println("Conta salário: " +salaryAccount.getId());
        }
        if(checkingAccount == null && savingsAccount == null && salaryAccount == null){
            System.out.println("Nenhuma conta cadastrada");
        }
        
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

    

    
}
