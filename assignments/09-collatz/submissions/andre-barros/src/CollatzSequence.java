import java.util.Scanner;

public class CollatzSequence {

    // Retorna o próximo número da sequência de Collatz
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2; // se par
        } else {
            return (n * 3) + 1; // se ímpar
        }
    }

    // Calcula a soma dos termos da sequência de Collatz a partir de n
    public static int calculateCollatzSum(int n) {
        int sum = 0;
        int current = n;

        while (current != 1) {
            sum += current;
            current = nextCollatz(current);
        }
        sum += 1; // adiciona o último termo (1)
        return sum;
    }

    // Programa principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        if (!sc.hasNextInt()) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            sc.close();
            return;
        }

        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
        } else {
            // imprimir sequência
            System.out.print("Sequência de Collatz: ");
            int current = n;
            System.out.print(current);

            while (current != 1) {
                current = nextCollatz(current);
                System.out.print(" → " + current);
            }
            System.out.println();

            // imprimir soma
            int sum = calculateCollatzSum(n);
            System.out.println("Soma dos termos: " + sum);
        }

        sc.close();
    }
}
