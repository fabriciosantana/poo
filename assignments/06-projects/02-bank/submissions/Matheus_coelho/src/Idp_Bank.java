import java.util.Scanner;

public class Idp_Bank{
  

    public static void Abrir_conta() {

        Scanner scanner = new Scanner(System.in);
        Sy3+
        +2stem.out.print("Primeiro nome: ");
        String firstName = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String lastName = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Customer cliente = new Customer(firstName, lastName, cpf);
        Account conta = new Account();
        cliente.addAccount(conta);

        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("Nome: " + cliente.getFirstName() + " " + cliente.getLastName());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Número da Conta: " + conta.getId());
        System.out.println("Saldo: R$ " + conta.getBalance());
        System.out.println("Conta criada com sucesso! Pressione Enter para continuar...");
        scanner.nextLine();
    }
public static void main(String[] args) {
System.out.println("Bem vindo Idp_Bank insi ");
int Num = 0; // Initialize Num
switch (Num) {
    case 0:
        System.out.println("Indo para abrir conta");
        Abrir_conta();
        break;
    default:
        System.out.println("Num is not zero");
        break;
}
}
}