import java.util.Scanner;

public class SavingsAccountApp {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Informe o saldo inicial: ");
      double saldo = Double.parseDouble(scanner.nextLine());
      int mes = 1;
      double taxa = 0;
      while (true) {
        if (mes == 1) {
          System.out.println("Informe a taxa de juros anual (%): ");
          taxa = Double.parseDouble(scanner.nextLine());
        }
        else{
          System.out.println("Informe a nova taxa de juros anual: ");
          taxa = Double.parseDouble(scanner.nextLine());
          System.out.println("Alterando taxa de juros anual para " + taxa + "%...");
        }
        var savingsAccount = new SavingsAccount(saldo);
        try {
          SavingsAccount.setAnnualInterestRate(taxa);
        } catch (Exception e) {
          System.out.println(e);
        }
        for (int i = 1; i <= 12; i++) {
          savingsAccount.calculateMonthlyInterest();
          System.out.println("Mês " + mes + ": R$" + savingsAccount.getSavingsBalance());
          mes++;
        }
      }
  }
}
