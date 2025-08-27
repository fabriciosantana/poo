import java.util.Scanner;

public class CollatzSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.print("Digite um número inteiro positivo: ");
            n = scanner.nextInt();
            if (n < 1) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            }
        } while (n < 1);

        System.out.print("Sequência de Collatz: ");
        int current = n;
        long sum = 0;
        while (current != 1) {
            System.out.print(current + " → ");
            sum += current;
            current = nextCollatz(current);
        }
        System.out.println(current);
        sum += current;

        System.out.println("Soma dos termos: " + sum);

        scanner.close();
    }

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static long calculateCollatzSum(int n) {
        long sum = 0;
        int current = n;
        while (current != 1) {
            sum += current;
            current = nextCollatz(current);
        }
        sum += current; // Add the last term (1)
        return sum;
    }
}


