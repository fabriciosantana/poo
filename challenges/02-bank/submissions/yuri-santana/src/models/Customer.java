package models;

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
  }

  public boolean addAccount(Account account){
    accounts.add(account);
    return true;
  }

  public String displayInformation(){
    String informacoes = "Nome: " + this.getFirstName() + " " + this.getLastName() +"\n"
            +"CPF: " + this.getCpf() + "\n";
    for (Account account : accounts) {
      informacoes = informacoes.concat("Conta: " + account.getId() + "\n");
      informacoes = informacoes.concat("Saldo: " + account.getSaldo() + "\n");
    }
    return informacoes;
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

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
}
