import java.util.Scanner;

class IDPBank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer customer = null;
        Account account = null;

        while (true) {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("\n1. Abrir conta\n2. Consultar cliente\n3. Depositar\n4. Sacar\n5. Sair");
            System.out.print("\nDigite o número correspondente à opção desejada: ");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("\nDigite os dados para a abertura da conta.");
                    System.out.print("Primeiro nome: ");
                    String firstName = sc.nextLine();
                    System.out.print("Sobrenome: ");
                    String lastName = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    customer = createCustomer(firstName, lastName, cpf);
                    account = openAccount(customer);

                    System.out.println("\nCliente cadastrado com sucesso!\n");
                    System.out.println(customer.displayInformation());
                    System.out.println("\nConta criada com sucesso! Pressione Enter para continuar...");
                    sc.nextLine();
                    break;

                case 2:
                    if (customer != null) {
                        System.out.println("\n" + customer.displayInformation());
                    } else {
                        System.out.println("\nNenhum cliente cadastrado.");
                    }
                    System.out.println("\nPressione enter para continuar...");
                    sc.nextLine();
                    break;

                case 3:
                    if (account != null) {
                        System.out.print("\nDigite o valor que deseja depositar: ");
                        double depositAmount = sc.nextDouble();
                        deposit(account, depositAmount);

                        System.out.println("\nValor depositado com sucesso na conta do cliente " + customer.getFirstName() + " " + customer.getLastName());
                        System.out.println(customer.displayInformation());
                    } else {
                        System.out.println("\nNenhuma conta cadastrada.");
                    }
                    System.out.println("\nPressione enter para continuar...");
                    sc.nextLine(); sc.nextLine();
                    break;

                case 4:
                    if (account != null) {
                        System.out.print("\nDigite o valor que deseja sacar: ");
                        double withdrawAmount = sc.nextDouble();
                        withdraw(account, withdrawAmount);

                        System.out.println("\nValor sacado com sucesso da conta do cliente " + customer.getFirstName() + " " + customer.getLastName());
                        System.out.println(customer.displayInformation());
                    } else {
                        System.out.println("\nNenhuma conta cadastrada.");
                    }
                    System.out.println("\nPressione enter para continuar...");
                    sc.nextLine(); sc.nextLine();
                    break;

                case 5:
                    System.out.println("\nEncerrando o sistema...");
                    sc.close();
                    return;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }

    public static Customer createCustomer(String firstName, String lastName, String cpf) {
        return new Customer(firstName, lastName, cpf);
    }

    public static Account openAccount(Customer customer) {
        Account account = new Account();
        customer.addAccount(account);
        return account;
    }

    public static void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    public static void withdraw(Account account, double amount) {
        account.withdraw(amount);
    }
}

class Customer {
    private String firstName;
    private String lastName;
    private String cpf;
    private Account account;

    public Customer(String firstName, String lastName, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public boolean addAccount(Account account) {
        this.account = account;
        return true;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    public String displayInformation() {
        return String.format("Nome: %s %s\nCPF: %s\nNúmero da Conta: %d\nSaldo: %s",
                firstName, lastName, cpf, account.getId(), account.getFormattedBalance());
    }
}

class Account {
    private static int accountCounter = 1000;
    private int id;
    private double balance;

    public Account() {
        this.id = ++accountCounter;
        this.balance = 0.0;
    }

    public int getId() { return id; }

    public String getFormattedBalance() {
        return String.format("R$ %.2f", balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
