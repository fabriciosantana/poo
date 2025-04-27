//Nome: Allan Samuel Alves do Monte
//Matrícula: 24101279

import java.util.Scanner;

class IDPBank {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Customer customer = null;
        Account account = null;
        
        while (true) {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("Digite o número correspondente à opção desejada: ");
            
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
                        System.out.println("Nome: " + customer.getFirstName() + " " + customer.getLastName());
                        System.out.println("CPF: " + customer.getCpf());
                        System.out.println("Número da Conta: " + account.getId());
                        System.out.println("Saldo: R$ " + account.getBalance());
                    } else {
                        System.out.println("Nenhum cliente cadastrado.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Digite o valor que deseja depositar: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        account.deposit(amount);
                        System.out.println("Valor depositado com sucesso na conta do cliente " + customer.getFirstName() + " " + customer.getLastName() + ".");
                    } else {
                        System.out.println("Nenhuma conta cadastrada.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        System.out.print("Digite o valor que deseja sacar: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        account.withdraw(amount);
                        System.out.println("Valor sacado com sucesso da conta do cliente " + customer.getFirstName() + " " + customer.getLastName() + ".");
                    } else {
                        System.out.println("Nenhuma conta cadastrada.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    
    public static Customer createCustomer() {
        System.out.println("Digite os dados para a abertura da conta.");
        System.out.print("Primeiro nome: ");
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
        
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("Nome: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("CPF: " + customer.getCpf());
        System.out.println("Número da Conta: " + account.getId());
        System.out.println("Saldo: R$ " + account.getBalance());
        System.out.println("Conta criada com sucesso! Pressione Enter para continuar...");
        scanner.nextLine();
        
        return account;
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
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public Account getAccount() {
        return account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
}

class Account {
    private static int accountCounter = 1000;
    private int id;
    private double balance;
    
    public Account() {
        this.id = ++accountCounter;
        this.balance = 0.00;
    }
    
    public int getId() {
        return id;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }
}