import java.util.Scanner;

public class IDPBank {
    //Objeto 
    public class customer{

    private String firstName;
    private String lastName; 
    private String CPF;

    public customer(String firstName, String lastName, String CPF) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CPF = CPF;
     }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public static void main(String[] args) {
        int saldo = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
        System.out.println("1. Abrir conta");
        System.out.println("2. Consultar clientes");
        System.out.println("3. Depositar");
        System.out.println("4. Sacar");
        System.out.println("5. Sair");
        System.out.println("Escolha um opção: ");
        int option = scanner.nextInt();

        switch (option){
        case 1:
            System.out.println("Digite os dados para a abertura da conta.");

            System.out.print("Primeiro nome: ");
            String firstName = scanner.nextLine();

            System.out.print("Sobrenome: ");
            String lastName = scanner.nextLine();

            System.out.print("CPF: ");
            String CPF = scanner.nextLine();

            System.out.println("Cliente cadastrado com sucesso!");
            System.out.println("Nome: "+ customer.getFirstName() + "" + customer.getLastName());
            System.out.print("CPF: " + customer.getCPF());
            System.out.print("Número da Conta: ");

        case 2:

        case 3:
            System.out.println("Digite o valor que deseja depositar.");

        case 4:
            System.out.println("Digite o valor que deseja sacar.");
            System.out.println("Valor: ");

        case 5:

        if(option <= 1 | option > 5){
            System.out.println("Opção inválida. Tente novamente.");
            System.out.println("Digite o número correspondente à opção desejada: ");
        }
    }  
  }
 }
}
