import java.util.Scanner;

public class CollatzSequence {

    // Retorna o próximo número da sequência de Collatz
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;   // se par
        } else {
            return (n * 3) + 1; // se ímpar
        }
    }

    // Calcula a soma da sequência de Collatz e exibe a sequência
    public static int calculateCollatzSum(int n) {
        int soma = 0;
        StringBuilder sequencia = new StringBuilder();

        while (n != 1) {
            sequencia.append(n).append(" → ");
            soma += n;
            n = nextCollatz(n);
        }
        // adiciona o último termo "1"
        sequencia.append(1);
        soma += 1;

        System.out.println("Sequência de Collatz: " + sequencia.toString());
        return soma;
    }

    // Programa principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        if (!sc.hasNextInt()) {
            System.out.println("Erro: Entrada inválida. Deve ser um número inteiro positivo.");
            sc.close();
            return;
        }

        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
        } else {
            int soma = calculateCollatzSum(n);
            System.out.println("Soma dos termos: " + soma);
        }

        sc.close();
    }
}
