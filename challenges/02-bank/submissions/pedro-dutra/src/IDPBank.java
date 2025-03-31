import java.util.Scanner;

public class IDPBank {
    private static Customer clienteAtual = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
            Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\n
            1. Abrir conta.
            2. Consultar cliente. 
            3. Depositar.
            4. Sacar.
            5. Transferir.
            6. Sair.
            Digite o número correspondente à opção desejada: """);

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> createCustomer(scanner);
                case 2 -> consultCustomer(scanner);
                case 3 -> deposit(scanner);
                case 4 -> withdraw(scanner);
                case 5 -> transfer(scanner);
                case 6 -> {
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
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

        Account novaConta = openAccount();
        clienteAtual = new Customer(firstName, lastName, cpf, novaConta);

        System.out.println("Cliente cadastrado com sucesso!");
        clienteAtual.displayInformation();
    }

    public static Account openAccount() {
        return new Account();
    }

    public static void consultCustomer(Scanner scanner) {
        if (clienteAtual == null) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        if (clienteAtual.getCpf().equals(cpf)) {
            clienteAtual.displayInformation();
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public static void deposit(Scanner scanner) {
        if (clienteAtual == null) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.print("Digite o valor para depósito: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        clienteAtual.getAccounts().deposit(amount);
    }

    public static void withdraw(Scanner scanner) {
        if (clienteAtual == null) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.print("Digite o valor para saque: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        clienteAtual.getAccounts().withdraw(amount);
    }

    public static void transfer(Scanner scanner) {
        if (clienteAtual == null) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.print("Digite o valor para transferir: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (clienteAtual.getAccounts().getBalance() >= amount) {
            clienteAtual.getAccounts().withdraw(amount);
            System.out.println("Transferência simulada realizada.");
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }
}

