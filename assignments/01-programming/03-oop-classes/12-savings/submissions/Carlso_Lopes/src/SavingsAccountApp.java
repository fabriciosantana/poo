import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: R$ ");
        double savingsbalance = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double annulInterestRate = scanner.nextDouble();

        SavingsAccount conta = new SavingsAccount (savingsbalance, annulInterestRate);

        System.out.printf("Saldos com taxa de juros de %.1f%%\n", conta.getAnnulInterestRate());

        for(int i = 0 ; i < 12 ; i++){
            conta.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$ %.2f\n", (i+1), conta.getSavingsBalance());
        }

        //Update da Noxa Taxa Anual
        System.out.print("Informe a nova taxa de juros anual: ");
        double NovaTaxa = scanner.nextDouble();
        conta.setAnnulInterestRate(NovaTaxa);

        conta.calculateMonthlyInterest();
        System.out.println("Saldo com a nova taxa Anual: " + conta.getAnnulInterestRate());
        System.out.printf("Mês 13: R$%.2f\n", conta.getSavingsBalance());

    }
    
}