import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static long calculateCollatzSum(int n) {
        long sum = 0;
        long currentN = n;
        while (currentN != 1) {
            sum += currentN;
            if (currentN % 2 == 0) {
                currentN = currentN / 2;
            } else {
                currentN = (currentN * 3) + 1;
            }
        }
        sum += 1;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int n = scanner.nextInt();
        scanner.close();

        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            return;
        }

        StringBuilder sequence = new StringBuilder();
        int current = n;
        while (true) {
            sequence.append(current);
            if (current == 1) {
                break;
            }
            sequence.append(" -> ");
            current = nextCollatz(current);
        }

        System.out.println("Sequência de Collatz: " + sequence.toString());
        
        long sum = calculateCollatzSum(n);
        System.out.println("Soma dos termos: " + sum);
    }
}