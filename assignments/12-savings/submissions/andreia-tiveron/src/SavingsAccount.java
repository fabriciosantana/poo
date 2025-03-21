import java.util.Scanner;

class SavingsAccount{
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance){
        if(savingsBalance < 0){
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest(){
        double monthlyInterestRate = Math.pow(1 + annualInterestRate, 1.0 / 12) - 1;
        double monthlyInterest = savingsBalance * monthlyInterestRate;
        savingsBalance += monthlyInterest;
    }

    public static void setAnnualInterestRate(double rate){
        if (rate < 0){
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }

        annualInterestRate = rate/100.0;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }
}

class SavingsAccountApp{

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Informe o saldo inicial: ");
            double initialBalance = scanner.nextDouble();

            SavingsAccount account = new SavingsAccount(initialBalance);

            System.out.print("Informe a taxa de juros anual (%): ");
            double annualInterestRate = scanner.nextDouble();
            SavingsAccount.setAnnualInterestRate(annualInterestRate);
        
            System.out.printf("Saldos com taxa de juros de %.1f%%:%n", annualInterestRate);
        
            for (int month = 1; month <= 12; month++){
                account.calculateMonthlyInterest();
                System.out.printf("Mês %d: R$%.2f%n", month, account.getSavingsBalance());
        }

        System.out.print("\nInforme a nova taxa de juros anual: ");
        double newAnnualInterestRate = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(newAnnualInterestRate);

        account.calculateMonthlyInterest();
        System.out.printf("Alterando taxa de juros anual para %.1f%%...%n", newAnnualInterestRate);
        System.out.printf("\nMês 13: R$%.2f%n",account.getSavingsBalance());

        scanner.close();
    }
}

