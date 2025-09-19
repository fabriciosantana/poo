package Lucas_Pontual.src.collatz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollatzSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
        } else {
            List<Long> sequence = new ArrayList<>();
            long sum = calculateCollatzSum(n, sequence);

            System.out.print("Sequência de Collatz: ");
            for (int i = 0; i < sequence.size(); i++) {
                System.out.print(sequence.get(i));
                if (i < sequence.size() - 1) {
                    System.out.print(" → ");
                }
            }
            System.out.println();
            System.out.println("Soma dos termos: " + sum);
        }

        scanner.close();
    }

    public static long nextCollatz(long n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static long calculateCollatzSum(long n, List<Long> sequence) {
        long sum = 0;
        while (n != 1) {
            sequence.add(n);
            sum += n;
            n = nextCollatz(n);
        }
        sequence.add(1L);
        sum += 1;
        return sum;
    }
}


