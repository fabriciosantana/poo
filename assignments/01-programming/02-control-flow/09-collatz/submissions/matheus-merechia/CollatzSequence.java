import java.util.Scanner;

public class CollatzSequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Digite um número inteiro positivo: ");

            if (scanner.hasNextInt()) {
                n = scanner.nextInt();

                if (n > 0) {
                    break;
                }
            } else {
                scanner.next(); 
            }

            System.out.println("Erro: O número deve ser um inteiro positivo.");
        }

        System.out.print("Sequência de Collatz: ");
        printCollatzSequence(n);

        int soma = calculateCollatzSum(n);
        System.out.println("Soma dos termos: " + soma);

        scanner.close();
    }

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static int calculateCollatzSum(int n) {
        int soma = 0;

        while (true) {
            soma += n;

            if (n == 1) break;

            n = nextCollatz(n);
        }

        return soma;
    }

    public static void printCollatzSequence(int n) {
        while (true) {
            System.out.print(n);

            if (n == 1) {
                System.out.println();
                break;
            }

            System.out.print(" → ");
            n = nextCollatz(n);
        }
    }
}
