import java.util.Scanner;

public class IDPBank {
    static Scanner scanner = new Scanner(System.in);
    static Customer currentCustomer;
    static Account currentAccount;
    static int respostaConta = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("\nDigite o número correspondente à opção desejada: ");

            int resposta = scanner.nextInt();
            scanner.nextLine();
            int respostaConta;

            switch (resposta) {
                case 1:
                    System.out.println("Qual tipo de conta deseja abrir? ");
                    System.out.println("1. Conta corrente");
                    System.out.println("2. Conta poupança");
                    System.out.println("3. Conta salário");
                    respostaConta = scanner.nextInt();
                    scanner.nextLine();

                case 2:
                    displayCustomerInfo();
                    break;

                case 3:
                    System.out.print("Digite o valor para depósito: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;

                case 4:
                    System.out.print("Digite o valor para saque: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 5:

                case 6:
                    System.out.println("Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static Customer createCustomer(String firstName, String lastName, String cpf) {
        return new Customer(firstName, lastName, cpf);
    }

    public static Account openAccount(Customer customer) {
        Account account = null;
        switch (respostaConta) {
            case 1:
                account = new CheckingAccount();
                break;
            case 2:
                account = new SavingsAccount();
                break;
            case 3:
                account = new SalaryAccount();
                break;
            default:
                System.out.println("Erro");

        }
        return openAccount(customer);
    }

    public static void deposit(double amount) {
        if (currentAccount == null) {
            System.out.println("Erro: Nenhuma conta ativa encontrada.");
            return;
        }
        if (amount > 0) {
            currentAccount.deposit(amount);
        } else {
            System.out.println("O depósito deve ser um valor positivo.");
        }
    }

    public static void withdraw(double amount) {
        if (currentAccount == null) {
            System.out.println("Nenhuma conta ativa encontrada.");
            return;
        }
        if (amount > 0) {
            boolean success = currentAccount.withdraw(amount);
            if (!success) {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("O valor do saque deve ser positivo.");
        }
    }

    public static void displayCustomerInfo() {
        if (currentCustomer == null) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("\nInformações do Cliente:");
        System.out.println(currentCustomer.displayInformation());
    }

    public static void executeMonthlyProcessing() {
        if (currentCustomer == null) {
            System.out.println("Erro, voc^não tem nenhum cliente!");
            return;
        }
        if (currentCustomer.getCheckingAccount() != null) {
            currentCustomer.getCheckingAccount().applyMaitenanceFee();
        }
        if(currentCustomer.getSavingsAccount() != null){
            currentCustomer.getSavingsAccount().applyMaitenanceFee();
        }
        System.out.println("Processe concluído");

    }

}
