import java.util.InputMismatchException;
import java.util.Scanner;

public class Collatz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite um número inteiro positivo: ");
            int n = scanner.nextInt();

            if (n < 1) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            } else {
                System.out.print("Sequência de Collatz: ");
                
                int termoAtual = n;
                while (termoAtual != 1) {
                    System.out.print(termoAtual + " → ");
                    termoAtual = CollatzSequence.nextCollatz(termoAtual);
                }
                System.out.println(1);

                long soma = CollatzSequence.calculateCollatzSum(n);
                System.out.println("Soma dos termos: " + soma);
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, digite um número inteiro.");
        } finally {
            scanner.close();
        }
    }
}

class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static long calculateCollatzSum(int n) {
        long somaTotal = 0;
        int termoAtual = n;

        while (termoAtual != 1) {
            somaTotal += termoAtual;
            termoAtual = nextCollatz(termoAtual);
        }
        
        somaTotal += 1;

        return somaTotal;
    }
}
