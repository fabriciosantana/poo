import java.util.Scanner;

public class IDPBank {
    private static Customer customer = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("Digite o número correspondente à opção desejada: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcao) {
                case 1: abrirConta(); break;
                case 2: consultarCliente(); break;
                case 3: depositar(); break;
                case 4: sacar(); break;
                case 5: System.out.println("Obrigado por utilizar o IDP Bank!"); return;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void abrirConta() {
        System.out.println("\nDigite os dados para a abertura da conta.");
        System.out.print("Primeiro nome: ");
        String firstName = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String lastName = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        customer = new Customer(firstName, lastName, cpf);
        Account account = new Account();
        customer.addAccount(account);
        
        System.out.println("\nCliente cadastrado com sucesso!");
        System.out.println(customer.displayInformation());
    }

    
