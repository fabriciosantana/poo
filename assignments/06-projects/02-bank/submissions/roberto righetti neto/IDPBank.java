import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class IDPBank {
    private static ArrayList<Customer> clientes = new ArrayList<>();

    public static void main(String[] args) {
        loadCustomers();
        Scanner leitor = new Scanner(System.in);
        while (true) {
            System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\n");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Visualizar extrato");
            System.out.println("7. Sair\n");
            System.out.print("Digite o número correspondente à opção desejada: ");
            
            String entradaUsuario = leitor.nextLine();
            int opcao;
            try {
                opcao = Integer.parseInt(entradaUsuario);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.\n");
                continue;
            }

            try {
                switch (opcao) {
                    case 1:
                        abrirConta(leitor);
                        break;
                    case 2:
                        consultarCliente(leitor);
                        break;
                    case 3:
                        depositar(leitor);
                        break;
                    case 4:
                        sacar(leitor);
                        break;
                    case 5:
                        transferir(leitor);
                        break;
                    case 6:
                        visualizarExtrato(leitor);
                        break;
                    case 7:
                        saveCustomers();
                        System.out.println("Encerrando execução...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.\n");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static Customer createCustomer(String firstName, String lastName, String cpf) {
        Customer novoCliente = new Customer(firstName, lastName, cpf);
        clientes.add(novoCliente);
        return novoCliente;
    }

    public static Account openAccount(Customer customer, int accountType) {
        Account novaConta = null;
        switch (accountType) {
            case 1: novaConta = new CheckingAccount(); break;
            case 2: novaConta = new SavingsAccount(); break;
            case 3: novaConta = new SalaryAccount(); break;
            default: throw new IllegalArgumentException("Tipo de conta inválido.");
        }
        if (customer.addAccount(novaConta)) {
            return novaConta;
        }
        return null;
    }

    public static void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    public static void withdraw(Account account, double amount) {
        account.withdraw(amount);
    }

    private static void abrirConta(Scanner leitor) {
        System.out.println("Digite os dados para a abertura da conta.\n");
        System.out.print("Primeiro nome: ");
        String firstName = leitor.nextLine();
        System.out.print("Sobrenome: ");
        String lastName = leitor.nextLine();
        System.out.print("CPF: ");
        String cpf = leitor.nextLine();

        Customer cliente = findCustomerByCpf(cpf);
        if (cliente == null) {
            cliente = createCustomer(firstName, lastName, cpf);
        }

        System.out.println("\nQual tipo de conta deseja abrir?");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        System.out.println("3. Conta Salário");
        System.out.print("Digite o número da opção desejada: ");
        int tipoConta = Integer.parseInt(leitor.nextLine());

        Account contaGerada = openAccount(cliente, tipoConta);
        if(contaGerada != null) {
            saveCustomers();
            System.out.println("\nCliente cadastrado/atualizado com sucesso!\n");
            System.out.println(cliente.displayInformation());
            System.out.println("Conta criada com sucesso! Pressione Enter para continuar...");
        } else {
            System.out.println("Falha ao criar conta. Pressione Enter para continuar...");
        }
        leitor.nextLine();
    }

    private static void consultarCliente(Scanner leitor) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = leitor.nextLine();
        Customer cliente = findCustomerByCpf(cpf);
        if (cliente != null) {
            System.out.println(cliente.displayInformation());
        } else {
            System.out.println("Cliente não encontrado.");
        }
        System.out.println("Pressione enter para continuar...");
        leitor.nextLine();
    }

    private static void depositar(Scanner leitor) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = leitor.nextLine();
        Customer cliente = findCustomerByCpf(cpf);
        if (cliente != null) {
            Account conta = selectAccount(leitor, cliente);
            if (conta != null) {
                if (conta instanceof SalaryAccount) {
                    System.out.println("Conta Salário não permite depósitos manuais.");
                } else {
                    System.out.print("\nValor: ");
                    double valorDeposito = Double.parseDouble(leitor.nextLine());
                    deposit(conta, valorDeposito);
                    TransactionLogger.logTransaction(cpf, "DEPÓSITO", valorDeposito, conta.getBalance());
                    saveCustomers();
                    System.out.println("\nValor depositado com sucesso na conta do cliente " + cliente.getFirstName() + " " + cliente.getLastName() + ".\n");
                    System.out.println(cliente.displayInformation());
                }
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
        System.out.println("Pressione enter para continuar...");
        leitor.nextLine();
    }

    private static void sacar(Scanner leitor) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = leitor.nextLine();
        Customer cliente = findCustomerByCpf(cpf);
        if (cliente != null) {
            Account conta = selectAccount(leitor, cliente);
            if (conta != null) {
                System.out.print("\nValor: ");
                double valorSaque = Double.parseDouble(leitor.nextLine());
                withdraw(conta, valorSaque);
                TransactionLogger.logTransaction(cpf, "SAQUE", valorSaque, conta.getBalance());
                saveCustomers();
                System.out.println("\nValor sacado com sucesso da conta do cliente " + cliente.getFirstName() + " " + cliente.getLastName() + ".\n");
                System.out.println(cliente.displayInformation());
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
        System.out.println("Pressione enter para continuar...");
        leitor.nextLine();
    }

    private static void transferir(Scanner leitor) {
        System.out.print("Digite o CPF de origem: ");
        String cpfOrigem = leitor.nextLine();
        Customer clienteOrigem = findCustomerByCpf(cpfOrigem);
        if (clienteOrigem == null) {
            System.out.println("Cliente de origem não encontrado.");
            return;
        }
        System.out.println("Selecione a conta de origem:");
        Account contaOrigem = selectAccount(leitor, clienteOrigem);
        if (contaOrigem == null) return;

        System.out.print("Digite o CPF de destino: ");
        String cpfDestino = leitor.nextLine();
        Customer clienteDestino = findCustomerByCpf(cpfDestino);
        if (clienteDestino == null) {
            System.out.println("Cliente de destino não encontrado.");
            return;
        }
        
        System.out.println("Selecione a conta de destino:");
        Account contaDestino = selectAccount(leitor, clienteDestino);
        if (contaDestino == null) return;

        System.out.print("Valor da transferência: ");
        double valorTransferencia = Double.parseDouble(leitor.nextLine());
        
        contaOrigem.withdraw(valorTransferencia); 
        try {
            contaDestino.deposit(valorTransferencia);
        } catch(Exception e) {
            contaOrigem.deposit(valorTransferencia); 
            throw new RuntimeException("Falha na transferência. Valor devolvido. Erro: " + e.getMessage());
        }

        TransactionLogger.logTransaction(cpfOrigem, "TRANSFERÊNCIA ENVIADA", valorTransferencia, contaOrigem.getBalance());
        TransactionLogger.logTransaction(cpfDestino, "TRANSFERÊNCIA RECEBIDA", valorTransferencia, contaDestino.getBalance());
        saveCustomers();
        System.out.println("Transferência realizada com sucesso!");
        System.out.println("Pressione enter para continuar...");
        leitor.nextLine();
    }

    private static void visualizarExtrato(Scanner leitor) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = leitor.nextLine();
        TransactionLogger.displayTransactions(cpf);
        System.out.println("\nPressione enter para continuar...");
        leitor.nextLine();
    }

    private static Customer findCustomerByCpf(String cpf) {
        for (Customer cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) return cliente;
        }
        return null;
    }

    private static Account selectAccount(Scanner leitor, Customer cliente) {
        ArrayList<Account> listaContas = cliente.getAccounts();
        if (listaContas.isEmpty()) {
            System.out.println("Cliente não possui contas.");
            return null;
        }
        for (int i = 0; i < listaContas.size(); i++) {
            System.out.println((i + 1) + ". Conta ID: " + listaContas.get(i).getId() + " | Saldo: " + listaContas.get(i).getFormattedBalance());
        }
        System.out.print("Escolha a conta: ");
        int escolha = Integer.parseInt(leitor.nextLine());
        if (escolha < 1 || escolha > listaContas.size()) {
            System.out.println("Escolha inválida.");
            return null;
        }
        return listaContas.get(escolha - 1);
    }

    @SuppressWarnings("unchecked")
    private static void loadCustomers() {
        File arquivoDeClientes = new File("clientes.dat");
        if (arquivoDeClientes.exists()) {
            try (ObjectInputStream leitorObjetos = new ObjectInputStream(new FileInputStream(arquivoDeClientes))) {
                clientes = (ArrayList<Customer>) leitorObjetos.readObject();
                int maiorId = 1000;
                for (Customer cliente : clientes) {
                    for (Account conta : cliente.getAccounts()) {
                        if (conta.getId() > maiorId) maiorId = conta.getId();
                    }
                }
                Account.setAccountCounter(maiorId);
            } catch (Exception e) {
                System.out.println("Erro ao carregar clientes: " + e.getMessage());
            }
        }
    }

    private static void saveCustomers() {
        try (ObjectOutputStream escritorObjetos = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            escritorObjetos.writeObject(clientes);
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }
}

class Customer implements Serializable {
    private String firstName;
    private String lastName;
    private String cpf;
    private ArrayList<Account> accounts;

    public Customer(String firstName, String lastName, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.accounts = new ArrayList<>();
    }

    public boolean addAccount(Account account) {
        if (this.accounts.size() >= 3) {
            System.out.println("Cliente já atingiu o limite de contas.");
            return false;
        }
        this.accounts.add(account);
        return true;
    }

    public String displayInformation() {
        StringBuilder textoInfo = new StringBuilder();
        textoInfo.append("Nome: ").append(firstName).append(" ").append(lastName).append("\n");
        textoInfo.append("CPF: ").append(cpf).append("\n");
        for (Account conta : accounts) {
            textoInfo.append("Número da Conta: ").append(conta.getId()).append(" | Saldo: ").append(conta.getFormattedBalance()).append("\n");
        }
        return textoInfo.toString();
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public ArrayList<Account> getAccounts() { return accounts; }
}

abstract class Account implements Serializable {
    private static int accountCounter = 1000;
    protected int id;
    protected double balance;
    protected ArrayList<Transaction> transactions;

    public Account() {
        accountCounter++;
        this.id = accountCounter;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public static void setAccountCounter(int counter) {
        accountCounter = counter;
    }

    public int getId() { return id; }
    public double getBalance() { return balance; }
    
    public void setBalance(double balance) {
        if (balance < 0 && !(this instanceof CheckingAccount)) {
            throw new IllegalArgumentException("Saldo não pode ser negativo.");
        }
        this.balance = balance;
    }

    public String getFormattedBalance() {
        return String.format("R$ %.2f", balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Valor de depósito inválido.");
        this.balance += amount;
        addTransaction(new Transaction("Depósito", amount));
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Valor de saque inválido.");
        if (this.balance - amount < 0) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        this.balance -= amount;
        addTransaction(new Transaction("Saque", amount));
    }

    protected void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
    
    public ArrayList<Transaction> getTransactionHistory() {
        return transactions;
    }
}

class CheckingAccount extends Account {
    private double maintenanceFee = 10.0;

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Valor de saque inválido.");
        if (this.balance - amount < -500) {
            throw new IllegalArgumentException("Saldo insuficiente e sem limite de crédito.");
        }
        this.balance -= amount;
        addTransaction(new Transaction("Saque", amount));
    }

    public void applyMaintenanceFee() {
        this.balance -= maintenanceFee;
        addTransaction(new Transaction("Taxa Manutenção", maintenanceFee));
    }
}

class SavingsAccount extends Account {
    private double interestRate = 0.005;

    public void applyInterest() {
        double rendimento = this.balance * interestRate;
        this.balance += rendimento;
        addTransaction(new Transaction("Rendimento Poupança", rendimento));
    }
}

class SalaryAccount extends Account {
    @Override
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Valor inválido.");
        this.balance += amount;
        addTransaction(new Transaction("Depósito/Transferência", amount));
    }
}

class Transaction implements Serializable {
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getType() { return type; }
    public double getAmount() { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "[" + timestamp.format(formatador) + "] " + type + " de R$ " + String.format("%.2f", amount);
    }
}

class TransactionLogger {
    public static void logTransaction(String cpf, String operation, double amount, double finalBalance) {
        String nomeArquivoLog = "transacoes_" + cpf + ".txt";
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivoLog, true))) {
            String dataHoraStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            escritor.write(String.format("[%s] %s: R$%.2f | SALDO FINAL: R$%.2f%n", dataHoraStr, operation, amount, finalBalance));
        } catch (IOException e) {
            System.out.println("Erro ao gravar log de transação: " + e.getMessage());
        }
    }

    public static void displayTransactions(String cpf) {
        String nomeArquivoLog = "transacoes_" + cpf + ".txt";
        File arquivoLog = new File(nomeArquivoLog);
        if (!arquivoLog.exists()) {
            System.out.println("Ainda não houve movimentações na conta ou arquivo não existe.");
            return;
        }
        try (BufferedReader leitorLog = new BufferedReader(new FileReader(arquivoLog))) {
            String linhaAtual;
            System.out.println("Histórico de transações:");
            while ((linhaAtual = leitorLog.readLine()) != null) {
                System.out.println(linhaAtual);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler extrato: " + e.getMessage());
        }
    }
}
