
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IDPBank {
    private static List<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== IDP BANK =====");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            switch (opcao) {
                case 1:
                    abrirConta();
                    break;
                case 2:
                    consultarCliente();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    sacar();
                    break;
                case 5:
                    System.out.println("Saindo do sistema. Até logo!");
                    scanner.close();
                    return;
                    default :
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
                }
            }
        }
        
        private static void abrirConta() {
        System.out.println("\nDigite os dados do cliente para abrir a conta:");

        System.out.print("Primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Customer cliente = new Customer(firstName, lastName, cpf);
        Account conta = new Account();
        cliente.addAccount(conta);
        customers.add(cliente);

        System.out.println("\nConta criada com sucesso!");
        System.out.println(cliente.displayInformation());
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void consultarCliente() {
        System.out.print("\nDigite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        for (Customer c : customers) {
            if (c.getCpf().equals(cpf)) {
                System.out.println("\nCliente encontrado:");
                System.out.println(c.displayInformation());
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void depositar() {
        System.out.print("\nDigite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        for (Customer c : customers) {
            if (c.getCpf().equals(cpf)) {
                System.out.print("Digite o valor para depositar: R$ ");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                
                if (c.getAccount().deposit(valor)) {
                    System.out.println("Depósito realizado com sucesso!");
                } else {
                    System.out.println("Valor inválido.");
                }

                System.out.println(c.displayInformation());
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void sacar() {
        System.out.print("\nDigite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        for (Customer c : customers) {
            if (c.getCpf().equals(cpf)) {
                System.out.print("Digite o valor para sacar: R$ ");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                boolean sucesso = c.getAccount().withdraw(valor);

                if (sucesso) {
                    System.out.println("Saque realizado com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente ou valor inválido.");
                }

                System.out.println(c.displayInformation());
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }
}


