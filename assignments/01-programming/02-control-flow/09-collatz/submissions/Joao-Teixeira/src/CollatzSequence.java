import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static long calculateCollatzSum(int n) {
        long soma = 0;
        int atual = n;

        System.out.print("Sequência de Collatz: ");
        
        while (atual != 1) {
            System.out.print(atual + " → ");
            soma += atual;
            atual = nextCollatz(atual);
        }
        
        System.out.println(1);
        soma += 1; 
        
        return soma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("Erro: A entrada deve ser um número inteiro.");
        } else {
            int n = scanner.nextInt();

            if (n < 1) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            } else if (n == 1) {
                System.out.println("Sequência de Collatz: 1");
                System.out.println("Soma dos termos: 1");
            } else {
                long somaTotal = calculateCollatzSum(n);
                System.out.println("Soma dos termos: " + somaTotal);
            }
        }

        scanner.close();
    }
}