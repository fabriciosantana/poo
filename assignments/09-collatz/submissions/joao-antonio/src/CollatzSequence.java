import java.util.Scanner;

public class CollatzSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seed;

        System.out.print("Digite um número inteiro positivo: ");

        if (scanner.hasNextInt()) {
            seed = scanner.nextInt();
            if (seed < 1) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            } else {
                long sum = calculateCollatzSum(seed);
                System.out.println("Soma dos termos: " + sum);
            }
        } else {
            System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
        }
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
        long current = n;
        long sum = 0;

        System.out.print("Sequência de Collatz: " + current);
        while (current != 1) {
            sum += current;
            if (current % 2 == 0) {
                current = current / 2;
            } else {
                current = (current * 3) + 1;
            }
            System.out.print(" → " + current);
        }
        sum = sum + 1;
        System.out.println();
        return sum;
    }
}