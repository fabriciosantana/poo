public class SavingsAccount {
  private double savingsBalance;
  private static double annualInterestRate;

  public SavingsAccount(double savingsBalance) {
    if (savingsBalance < 0) {
      throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
    }
    this.savingsBalance = savingsBalance;
  }

  public double calculateMonthlyInterest() {
    double taxaMensal = (Math.pow((1 + (getAnnualInterestRate() / 100.0)), (1.0 / 12.0))) - 1.0;
    double valorMensal = (this.savingsBalance * (1 + taxaMensal));
    this.setSavingsBalance(valorMensal);
    return valorMensal;
  }

  public double getSavingsBalance() {
    return savingsBalance;
  }

  public void setSavingsBalance(double savingsBalance) {
    this.savingsBalance = savingsBalance;
  }

  public static double getAnnualInterestRate() {
    return annualInterestRate;
  }

  public static void setAnnualInterestRate(double annualInterestRate) {
    if (annualInterestRate < 0) {
      throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
    }
    SavingsAccount.annualInterestRate = annualInterestRate;
  }
}
