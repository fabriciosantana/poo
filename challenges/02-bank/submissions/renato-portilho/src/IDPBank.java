import java.util.Scanner;

public class IDPBank {
    static Scanner scanner = new Scanner(System.in);
    static Customer currentCustomer;
    static Account currentAccount;

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

            switch (resposta) {
                case 1:
                    System.out.print("Primeiro nome: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Sobrenome: ");
                    String lastName = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    currentCustomer = createCustomer(firstName, lastName, cpf);
                    currentAccount = openAccount(currentCustomer);

                    System.out.println("Conta criada com sucesso! Número da conta: " + currentAccount.getId());
                    break;

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
        Account newAccount = new Account();
        customer.addAccount(newAccount);
        return newAccount;
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
}
