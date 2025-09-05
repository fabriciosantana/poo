import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
        }
    }

    public static int calculateCollatzSum(int n) {
        int sum = 0;
        while (n != 1) {
            sum += n;
            n = nextCollatz(n);
        }
        sum += 1;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");

        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            return;
        }

        System.out.print("Sequência de Collatz: " + n);

        int temp = n;

        while (temp != 1) {
            temp = nextCollatz(temp);
            System.out.print(" -> " + temp);
        }

        System.out.println();

        int soma = calculateCollatzSum(n);

        System.out.println("Soma dos termos: " + soma);
        
    }
}
