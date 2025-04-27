import java.util.ArrayList;
import java.util.Scanner;
import models.Account;
import models.CheckingAccount;
import models.Customer;
import models.SalaryAccount;
import models.SavingsAccount;

public class IDPBank {
  public static void main(String[] args) {
    int n = 0;
    ArrayList<Customer> clientes = new ArrayList<>();
    while (n != 7) {
      System.out.println("""
          Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\n
          1. Abrir conta
          2. Consultar cliente
          3. Depositar
          4. Sacar
          5. Tranferir
          6. Historico
          7. Sair
          Digite o número correspondente à opção desejada: 
          """);

      Scanner scanner = new Scanner(System.in);
      n = scanner.nextInt();
      switch (n) {
        case 1 -> {
          String cpf = scanner.nextLine();
          Customer customer = consultarClienteExiste(cpf,clientes);
          if(!(customer == null)){
            openAccount(customer);
          }
          else{
            System.out.println("usuário não encontrado, crie uma conta: ");
            System.out.println("primeiro nome: " );
            String firstName = scanner.nextLine();
            System.out.println("Segundo nome " );
            String lastName = scanner.nextLine();
            customer = createCustomer(firstName, lastName, cpf);
          }
          clientes.add(customer);
          System.out.println("Sucesso");
        }
        case 2 -> {
          String cpf = scanner.nextLine();
        }
        case 3 -> {
        }
        case 4 -> {
        }
        case 5 -> {
        }
        case 6 -> {
        }
        default -> System.out.println("Opção inválida. Tente novamente.");
      }
    }
  }

  public static Customer createCustomer(String firstName, String lastName, String cpf) {
    Customer custumer = new Customer(firstName, lastName, cpf);
    openAccount(custumer);
    return custumer;
  }
  
  public static Account openAccount(Customer customer) {
    System.out.println("""
      Qual tipo de conta deseja abrir?
      1. Conta Corrente
      2. Conta Poupança
      3. Conta Salário
      
      Digite o número da opção desejada:
      """);
      Scanner scanner = new Scanner(System.in);
      int tipo = scanner.nextInt();
      switch (tipo) {
        case 1 -> {
          CheckingAccount checkingAccount = new CheckingAccount();
          customer.addAccount(checkingAccount);
          return  checkingAccount;
        }
        case 2 -> {
          SavingsAccount savingsAccount = new SavingsAccount();
          customer.addAccount(savingsAccount);
          return savingsAccount;
        }
        case 3 -> {
          SalaryAccount salaryAccount = new SalaryAccount();
          customer.addAccount(salaryAccount);
          return salaryAccount;
        }
      }
      return null;
    }
    
    public boolean deposit(double amount) {
      return false;
    }
    
    public boolean withdraw(double amount) {
      return false;
    }

    public static Customer consultarClienteExiste(String cpf,ArrayList<Customer> clientes){
          for (Customer customer : clientes) {
            if(customer.getCpf().equals(cpf)){
              return customer;
            }
          }
          return null;
    }
  }
  