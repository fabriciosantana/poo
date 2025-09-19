import java.util.Scanner;
public class CollatzApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Digite um número inteiro positivo: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    break; 
                } else {
                    System.out.println("Erro: O número deve ser um inteiro positivo.");
                }
            } else {
                System.out.println("Erro: Entrada inválida.");
                scanner.next(); 
            }
        }

        int sum = CollatzSequence.calculateCollatzSum(n);
        System.out.println("Soma dos termos: " + sum);

        scanner.close();
    }
}