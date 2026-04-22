import java.util.Scanner;
public class IDPBanck{
    
    public static void main(String[] args){
    
        int opcaoMenu; 

       do { 
            
        Scanner scanner= new Scanner(System.in);

            System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consulta cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");

            opcaoMenu = scanner.nextInt();

       } while (opcaoMenu !=5);

     
    };


   
}