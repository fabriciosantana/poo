package models;


public abstract class Account {
  private  int id;
  private double saldo;
  private static int accountcounter = 0;

  public Account() {
    this.id = ++accountcounter;
    this.saldo = 0.00;
  }

  public boolean deposit(double valor){
    this.saldo += valor;
    return true;
  }

  public boolean withdraw(double valor){
    if(this.saldo < valor){
      System.out.println("valor maior que o saldo da conta");
      return false;
    }
    else{
      this.saldo -= valor;
      return true;
    }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getSaldo() {
    return saldo;
  }
  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }
}
