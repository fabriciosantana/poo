import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static int calculateCollatzSum(int n) {
        int sum = n;
        while (n != 1) {
            n = nextCollatz(n);
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro positivo: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("Erro: Entrada inválida.");
            scanner.close();
            return;
        }

        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            scanner.close();
            return;
        }

        System.out.print("Sequência de Collatz: " + n);
        int temp = n;
        while (temp != 1) {
            temp = nextCollatz(temp);
            System.out.print(" → " + temp);
        }
        System.out.println();

        int sum = calculateCollatzSum(n);
        System.out.println("Soma dos termos: " + sum);

        scanner.close();
    }
}
