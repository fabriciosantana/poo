
import java.util.Scanner;

public class IDPBank {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo: ");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("Digite o número correspondente à opção desejada: ");

            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1 -> {System.out.println("Opção 1");}
                case 2 -> System.out.println("Opção 2");
                case 3 -> System.out.println("Opção 3");
                case 4 -> System.out.println("Opção 4");
                case 5 -> System.out.println("Opção 5");
                default -> System.out.println("Opção inválida. Tente novamente");
            }
        } while (true);
       
    }

    public static Customer createCustomer(String firstName, String lastName, String CPF){
        return null;
    }

    public static Account openAccount(Customer customer){
        return null;
    }

    public static double deposit(double amount){
        return 0.0;
    }

    public static double withdraw(double amount){
        return 0.0;
    }

    public static void printOpenAccountOption(){

        System.out.println("Digite os dados para a abertura da conta.");

        System.out.println("Primeiro nome: ");
        System.out.println("Sobrenome: ");
        System.out.println("CPF: ");
    }
}
