class Customer {

    private String firstName;
    private String lastName;
    private String cpf;
    private Account accounts; 

  
    public Customer(String firstName, String lastName, String cpf, Account accounts) {
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


    public Account getAccounts() {
        return accounts;
    }


    public void setAccounts(Account accounts) {
        this.accounts = accounts;
    }

    public boolean addAccount(Account accounts){
        this.accounts = accounts;
        return true;
    }
}
