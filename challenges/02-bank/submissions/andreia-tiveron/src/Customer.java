import java.util.ArrayList;
import java.util.Scanner;

class Customer{
    private String firstName;
    private String lastName;
    private String cpf;
    private Account account;

    public Customer(String firstName, String lastName, String cpf){
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getCPF(){
        return cpf;
    }

    public Account getAccount(){
        return account;
    }

    public void setAccount(Account account){
        this.account = account;
    }

    public String displayInformation(){
        return "Nome: " + getFullName() + "\nCPF: " + cpf + "\nNúmero da Conta: " + (account != null ? getAccount().getId() : "Sem conta") + "\nSaldo: " + (account != null ? account.getBalance() : "R$ 0.00") + "\n\nPressione enter para continuar...";
    }

}
class Account{
    private static int accountContador = 1000;
    private int id;
    private double balance;

    public Account(){
        this.id = ++accountContador;
        this.balance = 0.0;
    }

    public int getId(){
        return id;
    }

    public double getBalance(){
        return balance;
    }
        
    public void deposit(double amount){
        if (amount > 0){
            balance += amount;

        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) { // Verifica se há saldo suficiente
            balance -= amount;
            return true; // Saque bem-sucedido
        }
        return false; // Falha no saque (saldo insuficiente ou valor inválido)
    }
}

class IDPbank{
    private static ArrayList<Customer> customers = new ArrayList<>();
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int n;

    while(true){
    System.out.print("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\n\n" +

                    "1. Abrir conta\n" +
                    "2. Consultar cliente\n" +
                    "3. Depositar\n" +
                    "4. Sacar\n" +
                    "5. Sair\n" +

                    "Digite o número correspondente à opção desejada:  ");


    n = scanner.nextInt(); 
    scanner.nextLine();

    switch(n){
        case 1:
            System.out.print("Digite os dados para a abertura da conta.\n");
            System.out.print("Primeiro nome: ");
            String firstName = scanner.nextLine();
            System.out.print("Segundo nome: ");
            String lastName = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            Customer customer = new Customer(firstName, lastName, cpf);
            Account account = new Account();
            customer.setAccount(account);
            customers.add(customer);
            System.out.print("\nCliente cadastrado com sucesso!\n" + customer.displayInformation());
            break;

        case 2:
            System.out.print("Digite o CPF do cliente: ");
            cpf = scanner.nextLine();
            boolean achouClient = false;

            for (Customer cust : customers) {
                if (cust.getCPF().equals(cpf)) {
                    System.out.print("\n" + cust.displayInformation());
                    achouClient = true;
                    break;
                }
            }
            if (!achouClient) {
            System.out.println("Cliente não encontrado.");
            }
            break;

        case 3:
            System.out.print("Digite o CPF do cliente: ");
            cpf = scanner.nextLine();
            achouClient = false;

            for (Customer cust : customers) {
                if (cust.getCPF().equals(cpf)) {
                    System.out.print("Digite o valor a ser depositado: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); 
                    cust.getAccount().deposit(amount);
                    System.out.println("\n" + cust.displayInformation());
                    achouClient = true;
                    break;
                }
            }
            if (!achouClient) {
            System.out.println("Cliente não encontrado.");
            }
            break;

        case 4:
            System.out.print("Digite o CPF do cliente: ");
            cpf = scanner.nextLine();
            boolean found = false;
            for (Customer cust : customers) {
                if (cust.getCPF().equals(cpf)) {
                    System.out.print("Digite o valor a ser sacado: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); 

                    if (cust.getAccount().withdraw(amount)) {
                            System.out.println("\nSaque realizado com sucesso!");
                        } else {
                            System.out.println("\nSaldo insuficiente ou valor inválido!");
                        }
                        System.out.println(cust.displayInformation());
                        found = true;
                        break;
            }
        }
        if (!found) System.out.println("Cliente não encontrado.");
        break;
        

        case 5:
            System.out.print("\nSaindo...\n");
            break;
        
        default:
            System.out.println("Opção inválida. Tente novamente.");

            }
        }

    }
}
