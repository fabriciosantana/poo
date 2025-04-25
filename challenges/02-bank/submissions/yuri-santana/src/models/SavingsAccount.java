package models;

public class SavingsAccount extends Account{
  private final double interestRate = 0.5/100;

  public SavingsAccount() {
    super();
  }

  public boolean applyInterest(){
    return  withdraw(getSaldo()*interestRate);
  }
}
