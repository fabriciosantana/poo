import java.util.Scanner;

public class IDPBank {

    private static Customer customer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma opção:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("Opção: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    openAccountFlow(scanner);
                    break;
                case 2:
                    consultCustomer();
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    withdraw(scanner);
                    break;
                case 5:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (option != 5);

        scanner.close();
    }

    public static Customer createCustomer(String firstName, String lastName, String cpf) {
        return new Customer(firstName, lastName, cpf);
    }

    public static Account openAccount(Customer customer) {
        Account account = new Account();
        customer.addAccount(account);
        return account;
    }

    private static void openAccountFlow(Scanner scanner) {
        System.out.println("\nDigite os dados para abertura da conta:");

        System.out.print("Primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        customer = createCustomer(firstName, lastName, cpf);
        openAccount(customer);

        System.out.println("\nCliente cadastrado com sucesso!");
        System.out.println(customer.displayInformation());
    }

    public static void consultCustomer() {
        if (customer != null) {
            System.out.println(customer.displayInformation());
        } else {
            System.out.println("Nenhum cliente cadastrado.");
        }
    }

    public static void deposit(Scanner scanner) {
        if (customer == null) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.print("\nValor: ");
        double amount = scanner.nextDouble();

        customer.getAccount().deposit(amount);

        System.out.println("\nDepósito realizado com sucesso!");
        System.out.println(customer.displayInformation());
    }

    public static void withdraw(Scanner scanner) {
        if (customer == null) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.print("\nValor: ");
        double amount = scanner.nextDouble();

        customer.getAccount().withdraw(amount);

        System.out.println("\nSaque realizado!");
        System.out.println(customer.displayInformation());
    }
}