import java.util.Scanner;

public class IDPBank {


    private static Customer currentCustomer = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            
            System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\n" +
                               "1. Abrir conta\n" +
                               "2. Consultar cliente\n" +
                               "3. Depositar\n" +
                               "4. Sacar\n" +
                               "5. Sair\n");
            System.out.print("Digite o número correspondente à opção desejada: ");
            
            
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                option = 0;
            }

            switch(option) {
                case 1: 
                    System.out.println("\nDigite os dados para a abertura da conta.");
                    System.out.print("Primeiro nome: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Sobrenome: ");
                    String lastName = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    
                    
                    currentCustomer = createCustomer(firstName, lastName, cpf);
                    Account newAccount = openAccount(currentCustomer);
                    currentCustomer.addAccount(newAccount);
                    
                    System.out.println("\nCliente cadastrado com sucesso!\n");
                    System.out.println(currentCustomer.displayInformation());
                    System.out.println("Conta criada com sucesso! Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;
                    
                case 2: 
                    if(currentCustomer == null) {
                        System.out.println("\nNenhum cliente cadastrado. Por favor, abra uma conta primeiro.\n");
                    } else {
                        System.out.println("\n" + currentCustomer.displayInformation());
                    }
                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                    break;
                    
                case 3: 
                    if(currentCustomer == null) {
                        System.out.println("\nNenhum cliente cadastrado. Por favor, abra uma conta primeiro.\n");
                    } else {
                        System.out.println("\nDigite o valor que deseja depositar.");
                        System.out.print("Valor: ");
                        double depositAmount = 0;
                        try {
                            depositAmount = Double.parseDouble(scanner.nextLine());
                        } catch(NumberFormatException e) {
                            System.out.println("Valor inválido.");
                            break;
                        }
                        deposit(depositAmount);
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;
                    
                case 4: 
                    if(currentCustomer == null) {
                        System.out.println("\nNenhum cliente cadastrado. Por favor, abra uma conta primeiro.\n");
                    } else {
                        System.out.println("\nDigite o valor que deseja sacar.");
                        System.out.print("Valor: ");
                        double withdrawAmount = 0;
                        try {
                            withdrawAmount = Double.parseDouble(scanner.nextLine());
                        } catch(NumberFormatException e) {
                            System.out.println("Valor inválido.");
                            break;
                        }
                        withdraw(withdrawAmount);
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;
                    
                case 5: 
                    System.out.println("\nSaindo do sistema. Obrigado!");
                    break;
                    
                default:
                    System.out.println("\nOpção inválida. Tente novamente.\n");
            }
        } while(option != 5);

        scanner.close();
    }

    public static Customer createCustomer(String firstName, String lastName, String cpf) {
        return new Customer(firstName, lastName, cpf);
    }

    public static Account openAccount(Customer customer) {
        return new Account();
    }

    public static void deposit(double amount) {
        Account account = currentCustomer.getAccount();
        if(amount > 0) {
            account.deposit(amount);
            System.out.println("\nValor depositado com sucesso na conta do cliente " +
                               currentCustomer.getFirstName() + " " + currentCustomer.getLastName() + ".\n");
        } else {
            System.out.println("\nValor de depósito inválido.");
        }
        System.out.println(currentCustomer.displayInformation());
    }

    public static void withdraw(double amount) {
        Account account = currentCustomer.getAccount();
        if(amount > 0) {
            if(account.withdraw(amount)) {
                System.out.println("\nValor sacado com sucesso da conta do cliente " +
                                   currentCustomer.getFirstName() + " " + currentCustomer.getLastName() + ".\n");
            } else {
                System.out.println("\nSaldo insuficiente para saque.");
            }
        } else {
            System.out.println("\nValor de saque inválido.");
        }
        System.out.println(currentCustomer.displayInformation());
    }
}
