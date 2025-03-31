import java.util.Scanner;

public class IDPBank {

    private static Customer customer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("Digite o número correspondente à opção desejada: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine(); 
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println("\nDigite os dados para a abertura da conta.");
                    System.out.print("Primeiro nome: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Sobrenome: ");
                    String lastName = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    customer = createCustomer(firstName, lastName, cpf);
                    Account account = openAccount(customer);
                    customer.addAccount(account);

                    System.out.println("\nCliente cadastrado com sucesso!");
                    System.out.println(customer.displayInformation());
                    System.out.println("Conta criada com sucesso! Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;
                case 2:
                    if (customer != null) {
                        System.out.println("\n" + customer.displayInformation());
                    } else {
                        System.out.println("\nNenhum cliente cadastrado.");
                    }
                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;
                case 3:
                    if (customer != null && customer.getAccount() != null) {
                        System.out.println("\nDigite o valor que deseja depositar.");
                        System.out.print("Valor: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();

                        deposit(customer.getAccount(), depositAmount);
                        System.out.println("\nValor depositado com sucesso na conta do cliente " 
                                + customer.getFirstName() + " " + customer.getLastName() + ".");
                        System.out.println(customer.displayInformation());
                    } else {
                        System.out.println("\nNenhum cliente cadastrado ou conta inexistente.");
                    }
                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;
                case 4:
                    if (customer != null && customer.getAccount() != null) {
                        System.out.println("\nDigite o valor que deseja sacar.");
                        System.out.print("Valor: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();

                        withdraw(customer.getAccount(), withdrawAmount);
                        System.out.println("\nValor sacado com sucesso da conta do cliente " 
                                + customer.getFirstName() + " " + customer.getLastName() + ".");
                        System.out.println(customer.displayInformation());
                    } else {
                        System.out.println("\nNenhum cliente cadastrado ou conta inexistente.");
                    }
                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;
                case 5:
                    // Sair
                    System.out.println("\nEncerrando o sistema. Obrigado por usar o IDP Bank!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }

    public static Customer createCustomer(String firstName, String lastName, String cpf) {
        return new Customer(firstName, lastName, cpf);
    }

    public static Account openAccount(Customer customer) {
        return new Account();
    }

    public static void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    public static void withdraw(Account account, double amount) {
        account.withdraw(amount);
    }
}