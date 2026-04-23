import java.util.ArrayList;
import java.util.Scanner;

public class IDPBank {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;
        do {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Visualizar extrato");
            System.out.println("6. Sair");
            System.out.print("\nDigite o número correspondente à opção desejada: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        handleOpenAccount();
                        break;
                    case 2:
                        handleConsultCustomer();
                        break;
                    case 3:
                        handleDeposit();
                        break;
                    case 4:
                        handleWithdraw();
                        break;
                    case 5:
                        handleDisplayStatement();
                        break;
                    case 6:
                        System.out.println("Obrigado por utilizar o IDP Bank!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (option != 6);
    }

    private static void handleOpenAccount() {
        System.out.println("\nDigite os dados para a abertura da conta.");
        System.out.print("Primeiro nome: ");
        String firstName = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String lastName = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Customer customer = findCustomer(cpf);
        if (customer == null) {
            customer = createCustomer(firstName, lastName, cpf);
            customers.add(customer);
        }

        System.out.println("\nQual tipo de conta deseja abrir?");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        System.out.println("3. Conta Salário");
        System.out.print("Digite o número da opção desejada: ");
        int type = Integer.parseInt(scanner.nextLine());

        Account account = openAccount(customer, type);
        customer.addAccount(account);

        System.out.println("\nCliente cadastrado com sucesso!");
        System.out.println(customer.displayInformation());
        System.out.println("Conta criada com sucesso! Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void handleConsultCustomer() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Customer customer = findCustomer(cpf);
        if (customer != null) {
            System.out.println(customer.displayInformation());
        } else {
            System.out.println("Cliente não encontrado.");
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void handleDeposit() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Customer customer = findCustomer(cpf);
        if (customer == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Account account = selectAccount(customer);
        if (account == null) return;

        System.out.print("Digite o valor que deseja depositar: ");
        double amount = Double.parseDouble(scanner.nextLine());

        try {
            deposit(account, amount);
            TransactionLogger.logTransaction(customer.getCpf(), "DEPÓSITO", amount, account.getBalance());
            System.out.println("Valor depositado com sucesso.");
            System.out.println(customer.displayInformation());
        } catch (Exception e) {
            System.out.println("Erro ao depositar: " + e.getMessage());
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void handleWithdraw() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Customer customer = findCustomer(cpf);
        if (customer == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Account account = selectAccount(customer);
        if (account == null) return;

        System.out.print("Digite o valor que deseja sacar: ");
        double amount = Double.parseDouble(scanner.nextLine());

        try {
            withdraw(account, amount);
            TransactionLogger.logTransaction(customer.getCpf(), "SAQUE", amount, account.getBalance());
            System.out.println("Valor sacado com sucesso.");
            System.out.println(customer.displayInformation());
        } catch (Exception e) {
            System.out.println("Erro ao sacar: " + e.getMessage());
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void handleDisplayStatement() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        TransactionLogger.displayTransactions(cpf);
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static Customer findCustomer(String cpf) {
        for (Customer c : customers) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    private static Account selectAccount(Customer customer) {
        ArrayList<Account> accounts = customer.getAccounts();
        if (accounts.isEmpty()) {
            System.out.println("Cliente não possui contas.");
            return null;
        }
        if (accounts.size() == 1) return accounts.get(0);

        System.out.println("Selecione a conta:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i).getAccountType() + " (" + accounts.get(i).getId() + ")");
        }
        int choice = Integer.parseInt(scanner.nextLine());
        return accounts.get(choice - 1);
    }

    public static Customer createCustomer(String firstName, String lastName, String cpf) {
        return new Customer(firstName, lastName, cpf);
    }

    public static Account openAccount(Customer customer, int type) {
        switch (type) {
            case 1: return new CheckingAccount();
            case 2: return new SavingsAccount();
            case 3: return new SalaryAccount();
            default: return new CheckingAccount();
        }
    }

    public static void deposit(Account account, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Valor deve ser positivo.");
        account.deposit(amount);
    }

    public static void withdraw(Account account, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Valor deve ser positivo.");
        account.withdraw(amount);
    }
}
