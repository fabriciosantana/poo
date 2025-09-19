import java.util.Scanner;

public class CollatzSequence {

    // Retorna o próximo número da sequência de Collatz
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    // Calcula a soma de todos os termos da sequência de Collatz a partir de n
    public static int calculateCollatzSum(int n) {
        int soma = 0;
        int atual = n;

        while (true) {
            soma += atual;
            if (atual == 1) break;
            atual = nextCollatz(atual);
        }
        return soma;
    }

    // Método principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        if (!sc.hasNextInt()) {
            System.out.println("Erro: A entrada deve ser um número inteiro.");
            sc.close();
            return;
        }

        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            sc.close();
            return;
        }

        // Gera a sequência
        StringBuilder sequencia = new StringBuilder();
        int atual = n;
        while (true) {
            sequencia.append(atual);
            if (atual == 1) break;
            sequencia.append(" → ");
            atual = nextCollatz(atual);
        }

        // Calcula a soma
        int soma = calculateCollatzSum(n);

        // Exibe os resultados
        System.out.println("Sequência de Collatz: " + sequencia.toString());
        System.out.println("Soma dos termos: " + soma);

        sc.close();
    }
}
