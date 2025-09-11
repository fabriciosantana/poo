import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        if (!sc.hasNextInt()) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            return;
        }
        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            return;
        }

        String sequence = CollatzSequence.generateCollatzSequence(n);
        int sum = CollatzSequence.calculateCollatzSum(n);

        System.out.println("Sequência de Collatz: " + sequence);
        System.out.println("Soma dos termos: " + sum);
    }
}