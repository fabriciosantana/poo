import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        }
        return (n * 3) + 1;
    }

    public static int calculateCollatzSum(int n) {
        int sum = n;
        int current = n;

        while (current != 1) {
            current = nextCollatz(current);
            sum += current;
        }
        return sum;
    }

    public static List<Integer> generateSequence(int n) {
        List<Integer> sequence = new ArrayList<>();
        int current = n;

        while (current != 1) {
            sequence.add(current);
            current = nextCollatz(current);
        }
        sequence.add(1);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite um número inteiro positivo: ");

        if (!input.hasNextInt()) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            input.close();
            return;
        }

        int n = input.nextInt();

        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            input.close();
            return;
        }

        List<Integer> sequence = generateSequence(n);

        System.out.print("Sequência de Collatz: ");
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i));
            if (i < sequence.size() - 1) {
                System.out.print(" → ");
            }
        }
        System.out.println();
        System.out.println("Soma dos termos: " + calculateCollatzSum(n));

        input.close();
    }
}