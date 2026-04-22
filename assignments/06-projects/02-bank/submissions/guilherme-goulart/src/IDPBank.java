import java.util.Scanner;
import java.util.ArrayList;

public class IDPBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int options = 0;
        ArrayList<Customer> customers = new ArrayList<>();

        while (options != 6) {
            System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\r\n" + //
                        "\r\n" + //
                        "1. Abrir conta\r\n" + //
                        "2. Consultar cliente\r\n" + //
                        "3. Depositar\r\n" + //
                        "4. Sacar\r\n" + //
                        "5. Transferir\r\n" + //
                        "6. Sair\r\n" + //
                        "\r\n" + //
                        "Digite o número correspondente à opção desejada: ");

            int option = sc.nextInt();

            if(option == 1){
                System.out.println("Qual tipo de conta deseja abrir?\r\n"+
                "1. Conta Corrente\r\n" +
                "2. Conta Poupança\r\n" +
                "3. Conta Salário\r\n"+
                "\nDigite o número da opção desejada: ");

                int opt = sc.nextInt();
                // Continuar implementando
            } else if (option == 2) {
                for(Customer c : customers){
                    System.out.println(c.displayInformation() + "\n");
                }
                System.out.println("Pressione Enter para continuar...");
                sc.nextLine();
                sc.nextLine();
            } else if (option == 3) {
                System.out.print("Digite o valor que deseja depositar.\r\n" + //
                                        "\r\n" + //
                                        "Valor: ");
                double amount = sc.nextDouble();
                double newBalance = customer.getAccount().deposit(amount);

                System.out.println("Valor depositado com sucesso na conta do Cliente! Novo saldo: R$ " + newBalance);
            } else if (option == 4) {
                System.out.print("Digite o valor a ser sacado: ");
                double amount = sc.nextDouble();
                double newBalance = customer.getAccount().withdraw(amount);
                System.out.println("Valor sacado com sucesso da conta do Cliente! Novo saldo: R$ " + newBalance);

            } else if(option == 5) {

            } else if (option == 6) {
                System.out.println("Obrigado por usar o IDP Bank! Até a próxima!");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.\r\n" + //
                                        "\r\n" + //
                                        "Digite o número correspondente à opção desejada: ");
            }
        }
        sc.close();
    }

    public static Customer createCustomer(String firstName, String lastName, String CPF) {
        return new Customer(firstName, lastName, CPF);
    }

    public static Account openAccount(Customer customer){
        return new Account(customer);
    }

    public static double deposit(double amount){
        return 0.0;
    }

    public static double withdraw(double amount){
        return 0.0;
    }
}
