import java.util.Scanner;
import java.util.ArrayList;

public class IDPBank {
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("\nDigite o número correspondente à opção desejada: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    createCustomer(scanner);
                    break;
                case 2:
                    consultCustomer(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    withdraw(scanner);
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void createCustomer(Scanner scanner) {
        System.out.println("Digite os dados para a abertura da conta.");
        System.out.print("Primeiro nome: ");
        String firstName = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String lastName = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        Customer newCustomer = new Customer(firstName, lastName, cpf, new Account());
        customers.add(newCustomer);
        
        System.out.println("Cliente cadastrado com sucesso!");
        newCustomer.displayInformation();
    }

    public static void consultCustomer(Scanner scanner) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        
        for (Customer c : customers) {
            if (c.getCpf().equals(cpf)) {
                c.displayInformation();
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public static void deposit(Scanner scanner) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        
        for (Customer c : customers) {
            if (c.getCpf().equals(cpf)) {
                System.out.print("Digite o valor que deseja depositar: ");
                double amount = scanner.nextDouble();
                c.getAccounts().deposit(amount);
                c.displayInformation();
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public static void withdraw(Scanner scanner) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        
        for (Customer c : customers) {
            if (c.getCpf().equals(cpf)) {
                System.out.print("Digite o valor que deseja sacar: ");
                double amount = scanner.nextDouble();
                c.getAccounts().withdraw(amount);
                c.displayInformation();
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }
}
