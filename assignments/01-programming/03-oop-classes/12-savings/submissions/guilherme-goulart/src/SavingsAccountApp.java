import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Informe o saldo inicial: ");
            double saldoInicial = sc.nextDouble();

            System.out.print("Informe a taxa de juros anual (%): ");
            double taxaInicial = sc.nextDouble();

            SavingsAccount conta = new SavingsAccount(saldoInicial);
            conta.setAnnualInterestRate(taxaInicial);

            System.out.printf("%nSaldos com taxa de juros de %.1f%%:%n", conta.getAnnualInterestRate());
            for(int i = 1 ; i <= 12 ; i++){
                conta.calculateMonthlyInterest();
                System.out.printf("Mês %d: R$%.2f%n", i, conta.getSavingsBalance());
            }
            System.out.print("\nInforme a nova taxa de juros anual (%): ");
            double novaTaxa = sc.nextDouble();

            System.out.println("Alterando taxa de juros anual para " + novaTaxa + "%...");
            conta.setAnnualInterestRate(novaTaxa);

            conta.calculateMonthlyInterest();
            System.out.printf("%nMês 13: R$%.2f%n", conta.getSavingsBalance());
        }catch(IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }catch(Exception e) {
            System.err.println("Erro na entrada de dados.");
        } finally {
            sc.close();
        }
    }
}
