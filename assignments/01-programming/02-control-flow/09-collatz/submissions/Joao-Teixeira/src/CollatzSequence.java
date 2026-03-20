import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static int calculateCollatzSum(int n) {
        int sum = 0;
        int current = n;
        while (current != 1) {
            sum += current;
            current = nextCollatz(current);
        }
        sum += 1;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro positivo: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            return;
        }

        System.out.print("Sequência de Collatz: ");
        int current = n;
        while (current != 1) {
            System.out.print(current + " → ");
            current = nextCollatz(current);
        }
        System.out.println("1");

        int sum = calculateCollatzSum(n);
        System.out.println("Soma dos termos: " + sum);
    }
}
