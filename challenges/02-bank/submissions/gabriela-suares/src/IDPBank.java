import java.util.Scanner;

class IDPBank {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Customer customer = null;
        Account account = null;
        
        while (true) {
            System.out.println("\n1. Abrir conta\n2. Consultar cliente\n3. Depositar\n4. Sacar\n5. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    if (customer == null) {
                        customer = createCustomer();
                        account = openAccount(customer);
                    } else {
                        System.out.println("Já existe um cliente cadastrado.");
                    }
                    break;
                case 2:
                    if (customer != null && account != null) {
                        System.out.printf("Nome: %s %s\nCPF: %s\nNúmero da Conta: %d\nSaldo: R$ %.2f\n", 
                                          customer.getFirstName(), customer.getLastName(), 
                                          customer.getCpf(), account.getId(), account.getBalance());
                    } else {
                        System.out.println("Nenhum cliente cadastrado.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Valor para depositar: ");
                        deposit(scanner.nextDouble(), account);
                    } else {
                        System.out.println("Nenhuma conta cadastrada.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        System.out.print("Valor para sacar: ");
                        withdraw(scanner.nextDouble(), account);
                    } else {
                        System.out.println("Nenhuma conta cadastrada.");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    
    public static Customer createCustomer() {
        System.out.print("Nome: ");
        String firstName = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String lastName = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        return new Customer(firstName, lastName, cpf);
    }
    
    public static Account openAccount(Customer customer) {
        Account account = new Account();
        customer.setAccount(account);
        System.out.printf("Conta criada! Nome: %s %s | Conta: %d | Saldo: R$ %.2f\n", 
                          customer.getFirstName(), customer.getLastName(), account.getId(), account.getBalance());
        return account;
    }
    
    public static void deposit(double amount, Account account) {
        account.deposit(amount);
    }

    public static void withdraw(double amount, Account account) {
        account.withdraw(amount);
    }
}

class Customer {
    private String firstName, lastName, cpf;
    private Account account;
    
    public Customer(String firstName, String lastName, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }
    
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCpf() { return cpf; }
    public void setAccount(Account account) { this.account = account; }
}

class Account {
    private static int accountCounter = 1000;
    private int id;
    private double balance;
    
    public Account() {
        this.id = ++accountCounter;
        this.balance = 0.00;
    }
    
    public int getId() { return id; }
    public double getBalance() { return balance; }
    
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }
}
