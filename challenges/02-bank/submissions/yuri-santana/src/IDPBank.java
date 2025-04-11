import java.util.Scanner;
import models.Account;
import models.CheckingAccount;
import models.Customer;
import models.SalaryAccount;
import models.SavingsAccount;

public class IDPBank {
  public static void main(String[] args) {
    int n = 0;
    while (n != 6) {
      System.out.println("""
          Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\n
          1. Abrir conta
          2. Consultar cliente
          3. Depositar
          4. Sacar
          5. Tranferir
          6. Sair
          Digite o número correspondente à opção desejada: 
          """);

      @SuppressWarnings("resource")
      Scanner scanner = new Scanner(System.in);
      n = scanner.nextInt();
      Customer customer = new Customer(null, null, null);
      switch (n) {
        case 1 -> {
          customer = abrirConta(scanner);
        }
        case 2 -> {
          customer.displayInformation();
        }
        case 3 -> {
        }
        case 4 -> {
        }
        case 5 -> {
        }
        default -> System.out.println("Opção inválida. Tente novamente.");
      }
    }
  }

  public static Customer createCustomer(String firstName, String lastName, String cpf) {
    Customer custumer = new Customer(firstName, lastName, cpf);
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
        }
        case 2 -> {
          SavingsAccount savingsAccount = new SavingsAccount();
        }
        case 3 -> {
          SalaryAccount salaryAccount = new SalaryAccount();
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

    private static Customer abrirConta(Scanner scanner) {
      System.out.println("Digite os dados para a abertura da conta.\n");
      System.out.println("Primeiro nome: ");
      String firstName = scanner.next();
      System.out.println("Sobrenome: ");
      String lastName = scanner.next();
      System.out.println("CPF: ");
      String cpf = scanner.next();
      System.out.println();
      Customer custumer = createCustomer(firstName, lastName, cpf);
      //openAccount(custumer);
      System.out.println("Conta criada com sucesso!\n");
      System.out.println(custumer.displayInformation());
      return custumer;
    }
  }
  