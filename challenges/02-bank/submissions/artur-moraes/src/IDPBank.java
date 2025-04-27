import java.util.*;

public class IDPBank {
    private static List<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Ver histórico de transações");
            System.out.println("6. Sair");
            System.out.print("Digite o número correspondente à opção desejada: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": openAccount(); break;
                case "2": consultarCliente(); break;
                case "3": depositar(); break;
                case "4": sacar(); break;
                case "5": verHistorico(); break;
                case "6": System.out.println("Obrigado por usar o IDP Bank!"); return;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static Customer createCustomer(String firstName, String lastName, String cpf) {
        Customer customer = new Customer(firstName, lastName, cpf);
        customers.add(customer);
        return customer;
    }

    public static Account openAccount(Customer customer, int tipo) {
        Account acc;
        switch (tipo) {
            case 1: acc = new CheckingAccount(); break;
            case 2: acc = new SavingsAccount(); break;
            case 3: acc = new SalaryAccount(); break;
            default: return null;
        }
        customer.addAccount(acc);
        return acc;
    }

    private static Customer buscarClientePorCPF(String cpf) {
        for (Customer c : customers) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    private static void openAccount() {
        System.out.println("Digite os dados para a abertura da conta.");
        System.out.print("Primeiro nome: ");
        String firstName = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String lastName = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Customer customer = buscarClientePorCPF(cpf);
        if (customer == null) customer = createCustomer(firstName, lastName, cpf);

        System.out.println("Qual tipo de conta deseja abrir?\n1. Corrente\n2. Poupança\n3. Salário");
        int tipo = Integer.parseInt(scanner.nextLine());
        Account acc = openAccount(customer, tipo);

        System.out.println("Conta criada com sucesso!\n" + customer.displayInformation());
    }

    private static void consultarCliente() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Customer c = buscarClientePorCPF(cpf);
        if (c != null) System.out.println(c.displayInformation());
        else System.out.println("Cliente não encontrado.");
    }

    private static void depositar() {
        Customer c = solicitarClienteEConta("Depósito");
        if (c == null) return;

        Account acc = selecionarConta(c);
        System.out.print("Digite o valor para depositar: ");
        double valor = Double.parseDouble(scanner.nextLine());
        acc.deposit(valor);
        System.out.println("Valor depositado com sucesso!\n" + c.displayInformation());
    }

    private static void sacar() {
        Customer c = solicitarClienteEConta("Saque");
        if (c == null) return;

        Account acc = selecionarConta(c);
        System.out.print("Digite o valor para sacar: ");
        double valor = Double.parseDouble(scanner.nextLine());
        try {
            acc.withdraw(valor);
            System.out.println("Saque realizado com sucesso!\n" + c.displayInformation());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void verHistorico() {
        Customer c = solicitarClienteEConta("Ver histórico");
        if (c == null) return;

        Account acc = selecionarConta(c);
        System.out.println("Histórico de transações da conta " + acc.getId() + ":");
        for (Transaction t : acc.getTransactionHistory()) {
            System.out.println(t);
        }
    }

    private static Customer solicitarClienteEConta(String operacao) {
        System.out.print("Digite o CPF do cliente para " + operacao + ": ");
        String cpf = scanner.nextLine();
        Customer c = buscarClientePorCPF(cpf);
        if (c == null) {
            System.out.println("Cliente não encontrado.");
            return null;
        }
        return c;
    }

    private static Account selecionarConta(Customer c) {
        List<Account> contas = c.getAccounts();
        for (int i = 0; i < contas.size(); i++) {
            System.out.println((i + 1) + ". " + contas.get(i));
        }
        System.out.print("Escolha o número da conta: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        return contas.get(index);
    }
}
