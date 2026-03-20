import java.util.Scanner;

public class CollatzSequenceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero inteiro positivo: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Erro: O numero deve ser um inteiro positivo.");
        } else {
            int current = n;
            String sequence = "";

            while (current != 1) {
                sequence += current + " -> ";
                current = CollatzSequence.nextCollatz(current);
            }
            sequence += "1";

            long sum = CollatzSequence.calculateCollatzSum(n);

            System.out.println("Sequencia de Collatz: " + sequence);
            System.out.println("Soma dos termos: " + sum);
        }

        scanner.close();
    }
}
