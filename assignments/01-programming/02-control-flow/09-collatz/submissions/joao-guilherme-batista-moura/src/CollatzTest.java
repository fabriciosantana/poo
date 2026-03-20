import java.util.Scanner;

public class CollatzTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Teste direto: " + CollatzSequence.calculateCollatzSum(11));
        System.out.print("Digite um número inteiro positivo: ");

        if (!scanner.hasNextLong()) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
        } else {
            long n = scanner.nextLong();

            if (n < 1) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            } else {
                System.out.print("Sequência de Collatz: ");

                long current = n;

                while (current != 1) {
                    System.out.print(current + " → ");
                    current = CollatzSequence.nextCollatz(current);
                }
                System.out.println("1");

                long totalSum = CollatzSequence.calculateCollatzSum(n);
                System.out.println("Soma dos termos: " + totalSum);
            }
        }

        scanner.close();
    }
}