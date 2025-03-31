import java.util.Scanner;

abstract class Account {
    protected int id;
    protected double balance;
    private static int accountCounter = 1000;

    public Account() {
        this.id = ++accountCounter;
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getFormattedBalance() {
        return String.format("R$ %.2f", balance);
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}

class CheckingAccount extends Account {
    private static final double MAINTENANCE_FEE = 10.00;
    private static final double CREDIT_LIMIT = -500.00;

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= CREDIT_LIMIT) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente e sem limite de crédito.");
        }
    }

    public void applyMaintenanceFee() {
        balance -= MAINTENANCE_FEE;
    }
}

class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.005; // 0,5% ao mês

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    public void applyInterest() {
        balance += balance * INTEREST_RATE;
    }
}

class SalaryAccount extends Account {
    @Override
    public void deposit(double amount) {
        throw new UnsupportedOperationException("Depósitos manuais não são permitidos nesta conta.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }
}

class Customer {
    private String firstName;
    private String lastName;
    private String cpf;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;
    private SalaryAccount salaryAccount;

    public Customer(String firstName, String lastName, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void addAccount(Account account) {
        if (account instanceof CheckingAccount) {
            this.checkingAccount = (CheckingAccount) account;
        } else if (account instanceof SavingsAccount) {
            this.savingsAccount = (SavingsAccount) account;
        } else if (account instanceof SalaryAccount) {
            this.salaryAccount = (SalaryAccount) account;
        }
    }

    public void displayAccounts() {
        System.out.println("Cliente: " + getFullName());
        if (checkingAccount != null) System.out.println("Conta Corrente: " + checkingAccount.getFormattedBalance());
        if (savingsAccount != null) System.out.println("Conta Poupança: " + savingsAccount.getFormattedBalance());
        if (salaryAccount != null) System.out.println("Conta Salário: " + salaryAccount.getFormattedBalance());
    }
}

public class IDPBank {
    private static Customer cliente;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Sair");
            System.out.print("\nDigite a opção desejada: ");
            
            int opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1 -> abrirConta(sc);
                case 2 -> {
                    if (cliente != null) cliente.displayAccounts();
                    else System.out.println("Nenhum cliente cadastrado.");
                }
                case 3, 4, 5 -> System.out.println("Funcionalidade em desenvolvimento.");
                case 6 -> {
                    System.out.println("Programa encerrado.");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    public static void abrirConta(Scanner sc) {
        System.out.print("Digite o primeiro nome: ");
        String firstName = sc.nextLine();
        System.out.print("Digite o sobrenome: ");
        String lastName = sc.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = sc.nextLine();
        
        cliente = new Customer(firstName, lastName, cpf);
        System.out.println("Conta criada para " + cliente.getFullName());
    }
}
