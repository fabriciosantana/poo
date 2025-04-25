import java.util.Scanner;

public class CollatzSequence {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite um número inteiro positivo: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
                return;
            }
            
            int n = scanner.nextInt();
            
            if (n < 1) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
                return;
            }
            
            
            int sum = calculateCollatzSum(n);
            
            
            System.out.print("Sequência de Collatz: ");
            printCollatzSequence(n);
            
            
            System.out.println("\nSoma dos termos: " + sum);
        }
    }

    public static int nextCollatz(int n) {
        return (n % 2 == 0) ? n / 2 : (n * 3) + 1;
    }

    public static int calculateCollatzSum(int n) {
        int sum = 0;
        while (n != 1) {
            sum += n;
            n = nextCollatz(n);
        }
        sum += 1; 
        return sum;
    }

    public static void printCollatzSequence(int n) {
        while (n != 1) {
            System.out.print(n + " → ");
            n = nextCollatz(n);
        }
        System.out.print("1");
    }
}
