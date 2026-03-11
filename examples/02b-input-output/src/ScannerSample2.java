import java.util.Scanner;

public class ScannerSample2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = input.nextLine(); 

        System.out.print("Digite sua idade: ");
        int idade = input.nextInt(); 
        input.nextLine(); 

        System.out.print("Digite sua altura: ");
        double altura = input.nextDouble(); 
        input.nextLine(); 

        System.out.printf("Olá %s, você tem %d anos e %.2f m de altura.%n", nome, idade, altura);

        input.close(); 
    }
}
