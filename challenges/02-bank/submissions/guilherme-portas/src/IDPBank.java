import java.util.Scanner;

public class IDPBank {
    public static void main(String[] args) {
        int opcaoMenu;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo: \n");
        
        while(true) {
            try {
                Functions.clearTerminal();
                Functions.imprimeMenuInicial();
                opcaoMenu = scanner.nextInt();
                Functions.clearScanner(scanner);

                switch (opcaoMenu) {
                    case 1: {
                        Functions.clearTerminal();
                        System.out.println("Digite os dados para a abertura da conta.\n");
                        String primeiroNome = "", sobreNome = "", cpf = "";

                        while (true) {
                            System.out.print("Primeiro nome: ");
                            primeiroNome = scanner.nextLine();
                            if (!primeiroNome.isBlank())    break;
                            else    System.out.println("Primeiro nome inválido ou nulo.");
                        }
                        while (true) {
                            System.out.print("Sobrenome: ");
                            sobreNome = scanner.nextLine();
                            if (!sobreNome.isBlank())   break;
                            else    System.out.println("Sobrenome inválido ou nulo.");
                        }
                        while (true) {
                            System.out.print("CPF: ");
                            cpf = scanner.nextLine();
                            if(cpf.isBlank())   System.out.println("CPF inválido ou nulo.");
                            else {
                                StringBuilder sb = new StringBuilder(cpf);
                                for (int i = 0; i < sb.length(); i++)
                                    if (sb.charAt(i) < '0' || sb.charAt(i) > '9')   sb.deleteCharAt(i);
                                cpf = sb.toString();
                                break;
                            }
                        }

                        Customer cliente = createCustomer(primeiroNome, sobreNome, cpf);
                        cliente.accounts = openAccount(cliente);
                        break;
                    }
                    case 2: // TODO: consultar cliente
                        break;
                    case 3: // TODO: depositar
                        break;
                    case 4: // TODO: sacar
                        break;
                    case 5:
                        Functions.clearTerminal();
                        scanner.close();
                        System.out.println("Saindo...");
                        System.exit(0);
                    default:
                        Functions.clearTerminal();
                        System.out.println("Opção inválida. Tente novamente. \n");
                        break;
                }
                Functions.clearScanner(scanner);
            } catch (Exception InputMismatchException) {
                Functions.clearTerminal();
                System.out.println("Opção inválida. Tente novamente. \n");
                scanner.nextLine();
            }
        }
    }

   public static Customer createCustomer(String firstName, String lastName, String cpf) {
        Customer cliente = new Customer(firstName, lastName, cpf);
        return cliente;
   }

   public static Account openAccount(Customer customer) {
       StringBuilder builder = new StringBuilder(customer.cpf);
       int numAccount = Integer.parseInt(Functions.shuffleString(builder.toString()));
       Account conta = new Account(numAccount);

       Functions.clearTerminal();
       System.out.println("Cadastro realizado com sucesso!\n");
       System.out.println("Nome: " + customer.firstName + " " + customer.lastName);
       System.out.println("CPF: " + customer.cpf);
       System.out.println("Número da conta: " + numAccount);
       System.out.printf("Saldo: R$ %.2f \n\n", conta.getBalance());
       System.out.println("Conta criada com sucesso! Pressione enter para continuar...");
       try (Scanner scanner = new Scanner(System.in)) {
           scanner.nextLine();
       }

       return conta;
   }

    public static void deposit(double amount) {

    }

    public static void withdraw(double amount) {

    }
}
