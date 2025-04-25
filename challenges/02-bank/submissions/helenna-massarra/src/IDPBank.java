import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IDPBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Bem-vindo ao IDP Bank ===");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Histórico de transações");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.hasNextInt() ? scanner.nextInt() : -1;
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("\nDigite os dados para a abertura da conta.");
                    System.out.print("Primeiro nome: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Sobrenome: ");
                    String lastName = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    Customer existing = findCustomerByCpf(customers, cpf);
                    Customer customer = (existing != null) ? existing : new Customer(firstName, lastName, cpf);

                    System.out.println("\nQual tipo de conta deseja abrir?");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    System.out.println("3. Conta Salário");
                    System.out.print("Digite a opção: ");
                    int accType = scanner.nextInt();
                    scanner.nextLine();

                    Account newAccount = switch (accType) {
                        case 1 -> new CheckingAccount();
                        case 2 -> new SavingsAccount();
                        case 3 -> new SalaryAccount();
                        default -> null;
                    };

                    if (newAccount != null) {
                        customer.addAccount(newAccount);
                        if (existing == null) customers.add(customer);
                        System.out.println("Conta criada com sucesso!");
                    } else {
                        System.out.println("Tipo de conta inválido.");
                    }
                    break;

                case 2:
                    customer = selectCustomer(customers, scanner);
                    if (customer != null) {
                        System.out.println(customer.displayInformation());
                    }
                    break;

                case 3:
                    customer = selectCustomer(customers, scanner);
                    if (customer != null) {
                        Account account = selectAccount(customer, scanner);
                        if (account != null) {
                            System.out.print("Valor do depósito: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            account.deposit(amount);
                            System.out.println("Depósito realizado com sucesso!");
                        }
                    }
                    break;

                case 4:
                    customer = selectCustomer(customers, scanner);
                    if (customer != null) {
                        Account account = selectAccount(customer, scanner);
                        if (account != null) {
                            System.out.print("Valor do saque: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            if (account.withdraw(amount)) {
                                System.out.println("Saque realizado com sucesso!");
                            } else {
                                System.out.println("Saldo insuficiente.");
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("Transferência - Cliente de origem:");
                    Customer sender = selectCustomer(customers, scanner);
                    if (sender != null) {
                        Account from = selectAccount(sender, scanner);
                        if (from != null) {
                            System.out.println("Transferência - Cliente de destino:");
                            Customer receiver = selectCustomer(customers, scanner);
                            if (receiver != null) {
                                Account to = selectAccount(receiver, scanner);
                                if (to != null) {
                                    System.out.print("Valor a transferir: ");
                                    double amount = scanner.nextDouble();
                                    scanner.nextLine();
                                    if (from.withdraw(amount)) {
                                        to.deposit(amount);
                                        System.out.println("Transferência realizada!");
                                    } else {
                                        System.out.println("Saldo insuficiente.");
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 6:
                    customer = selectCustomer(customers, scanner);
                    if (customer != null) {
                        Account account = selectAccount(customer, scanner);
                        if (account != null) {
                            System.out.println("\n=== Histórico de Transações ===");
                            for (Transaction entry : account.getTransactionHistory()) {
                                System.out.println(entry.toString()); 
                            }
                        }
                    }
                    break;

                case 7:
                    System.out.println("Obrigado por usar o IDP Bank!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static Customer findCustomerByCpf(List<Customer> customers, String cpf) {
        for (Customer c : customers) {
            if (c.getCPF().equals(cpf)) return c;
        }
        return null;
    }

    private static Customer selectCustomer(List<Customer> customers, Scanner scanner) {
        if (customers.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return null;
        }

        System.out.println("\nClientes disponíveis:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getFullName() + " - CPF: " + customers.get(i).getCPF());
        }
        System.out.print("Escolha o cliente (número): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        } else {
            System.out.println("Cliente inválido.");
            return null;
        }
    }

    private static Account selectAccount(Customer customer, Scanner scanner) {
        List<Account> accounts = customer.getAccounts();
        if (accounts.isEmpty()) {
            System.out.println("O cliente não possui contas.");
            return null;
        }

        System.out.println("\nContas disponíveis:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i).getClass().getSimpleName() + " - Saldo: R$ " + accounts.get(i).getBalance());
        }
        System.out.print("Escolha a conta (número): ");
        int accIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (accIndex >= 0 && accIndex < accounts.size()) {
            return accounts.get(accIndex);
        } else {
            System.out.println("Conta inválida.");
            return null;
        }
    }
}
