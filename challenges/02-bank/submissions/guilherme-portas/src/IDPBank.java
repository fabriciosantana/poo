import java.util.Scanner;

public class IDPBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcaoMenu;

        System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo: \n");
        
        while(true) {
            try {
                Functions.imprimeMenuInicial();
                opcaoMenu = scanner.nextInt();

                switch (opcaoMenu) {
                    case 1: //TODO: gerar nova conta
                            break;
                    case 2: //TODO: consultar cliente
                            break;
                    case 3: //TODO: depositar
                            break;
                    case 4: //TODO: sacar
                            break;
                    case 5: Functions.clearTerminal();
                            System.out.println("Saindo...");
                            scanner.close();
                            System.exit(0);
                    default:    Functions.clearTerminal();
                                System.out.println("Opção inválida. Tente novamente. \n");
                                break;
                }
            } catch (Exception InputMismatchException) {
                Functions.clearTerminal();
                System.out.println("Opção inválida. Tente novamente. \n");
                scanner.nextLine();
            }
        }
    }

/*   public static Customer createCustomer(String firstName, String lastName, String CPF) {

    }

    public static Account openAccount(Customer customer) {

    }
*/
    public static void deposit(double amount) {

    }

    public static void withdraw(double amount) {

    }
}
