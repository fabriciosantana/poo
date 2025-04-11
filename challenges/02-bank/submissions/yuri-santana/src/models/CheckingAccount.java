package models;

public class CheckingAccount extends Account {
  private final double maintenanceFee = 10.0;

  

  public CheckingAccount() {
    super();
  }

  @Override
    public boolean withdraw(double valor) {
        if (getSaldo() - valor < 500){
          throw new IllegalArgumentException("Saldo insuficiente e sem limite de crédito.");
        }
        else {
          setSaldo(getSaldo() - valor);
          return true;
        }
    }

  public boolean applyMaintenanceFee() {
    return withdraw(maintenanceFee);
  }
}
