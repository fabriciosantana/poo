import java.util.Scanner;

class SavingsAccount {
    private double savingsBalance;
    public static double annualInterestRate;

public SavingsAccount(double savingsBalance) {
    if (savingsBalance < 0) {
    hrow new IllegalArgumentException("O saldo inicial não pode ser negativo.");
}
    this.savingsBalance = savingsBalance;
}

public void calculateMonthlyInterest() {
    double monthlyInterestRate = Math.pow(1 + annualInterestRate, 1.0 / 12) - 1;
    savingsBalance += savingsBalance * monthlyInterestRate;
}

public double getSavingsBalance() {
    return savingsBalance;
}

public static void setAnnualInterestRate(double rate) {
    if (rate < 0) {
    throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
}
        annualInterestRate = rate;
}

public static double getAnnualInterestRate() {
        return annualInterestRate;
}
}

public class SavingsAccountApp {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();
        System.out.print("Informe a taxa de juros anual (%): ");
        double annualRate = scanner.nextDouble() / 100;

SavingsAccount.setAnnualInterestRate(annualRate);
SavingsAccount account = new SavingsAccount(initialBalance);

 System.out.println("Saldos com taxa de juros de " + (annualRate * 100) + "%:");
        for (int month = 1; month <= 12; month++) {
        account.calculateMonthlyInterest();
        System.out.printf("Mês %d: R$%.2f\n", month, account.getSavingsBalance());
}

System.out.print("Informe a nova taxa de juros anual: ");
        double newAnnualRate = scanner.nextDouble() / 100;
        SavingsAccount.setAnnualInterestRate(newAnnualRate);

System.out.println("Alterando taxa de juros anual para " + (newAnnualRate * 100) + "%...");
        account.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f\n", account.getSavingsBalance());

scanner.close();
}
}
