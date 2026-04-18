import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("O numero deve ser um inteiro positivo.");
        }

        if (n % 2 == 0) {
            return n / 2;
        }

        return (n * 3) + 1;
    }

    public static int calculateCollatzSum(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("O numero deve ser um inteiro positivo.");
        }

        int sum = n;
        while (n != 1) {
            n = nextCollatz(n);
            sum += n;
        }
        return sum;
    }

    private static String buildSequence(int n) {
        StringBuilder sequence = new StringBuilder();
        sequence.append(n);

        while (n != 1) {
            n = nextCollatz(n);
            sequence.append(" -> ").append(n);
        }

        return sequence.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite um numero inteiro positivo: ");
            int n = scanner.nextInt();

            if (n < 1) {
                System.out.println("Erro: O numero deve ser um inteiro positivo.");
                return;
            }

            System.out.println("Sequencia de Collatz: " + buildSequence(n));
            System.out.println("Soma dos termos: " + calculateCollatzSum(n));
        }
    }
}
