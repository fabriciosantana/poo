import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n deve ser um inteiro positivo.");
        }
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
        }
    }

    public static int calculateCollatzSum(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n deve ser um inteiro positivo.");
        }
        long sum = 0;
        int current = n;
        while (true) {
            sum += current;
            if (current == 1) break;
            current = nextCollatz(current);
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = null;
        while (true) {
            System.out.print("Digite um número inteiro positivo: ");
            String line = sc.nextLine().trim();
            try {
                n = Integer.parseInt(line);
                if (n < 1) {
                    System.out.println("Erro: O número deve ser um inteiro positivo.");
                    continue;
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            }
        }
        StringBuilder seq = new StringBuilder();
        int current = n;
        int sum = 0;
        while (true) {
            seq.append(current);
            sum += current;
            if (current == 1) break;
            seq.append(" \u2192 ");
            current = nextCollatz(current);
        }
        System.out.println("Sequência de Collatz: " + seq.toString());
        System.out.println("Soma dos termos: " + sum);
        sc.close();
    }
}
