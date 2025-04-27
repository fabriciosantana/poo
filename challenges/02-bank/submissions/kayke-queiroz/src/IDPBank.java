import java.util.Scanner;

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
