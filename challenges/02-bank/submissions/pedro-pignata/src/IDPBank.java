import java.util.Scanner;

public class IDPBank {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("""
            Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\n
            1. Abrir conta
            2. Consultar cliente 
            3. Depositar
            4. Sacar 
            5. Sair
            Digite o número correspondente à opção desejada: """);

            int escolha = scanner.nextInt();
            scanner.nextLine();

            Customer customer = new Customer(null, null, null);

            switch (escolha) {
                case 1 -> customer = createCustomer();

                case 2 -> consultarCliente(customer);                

                case 3 -> depositar(customer);                

                case 4 -> sacar();                

                case 5 ->{ 
                System.out.println("Obrigado por usar o IDP Bank.");
                return; 
                }

                default ->{
                System.out.println(""
                +"Opção inválida. Tente novamente.\n"
                +"Digite o número correspondente à opção desejada: ");
                }
            }
        }
    }

    public static Customer createCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite os dados para a abertura da conta.\n");

        System.out.println("Primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.println("Sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.println("CPF: ");
        String cpf = scanner.nextLine();


        Customer customer = new Customer(firstName, lastName, cpf);
        Account account = new Account(0.0);

        customer.addAccount(account);

        System.out.println("\nCliente cadastrado com sucesso!\n\n");
        System.out.println(customer.displayInformation());
        System.out.println("\nConta criada com sucesso! Pressione Enter para continuar...\n");

        return customer;       
        }

    public static void consultarCliente(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(customer.displayInformation());
        System.out.println("\nPressione enter para continuar...");
        
    }

    public static void depositar(Customer customer) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor que deseja depositar.\n\n");
        
        System.out.println("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        customer.getAccount().deposit(valor);
        
        System.out.println("Valor depositado com sucesso na conta do cliente " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println(customer.displayInformation());
        System.out.println("\nPressione enter para continuar...");
        
    }
    
    public static void sacar() {
        System.out.println("Método de saque ainda não implementado.");
        
    }


}