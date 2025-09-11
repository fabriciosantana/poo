import java.util.Scanner;

public class CollatzSequence {

    // Método para calcular o próximo número da sequência de Collatz
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    // Método para gerar a sequência de Collatz e retornar a soma
    public static int calculateCollatzSum(int n) {
        int soma = 0;
        System.out.print("Sequência de Collatz: " + n); // imprime o primeiro termo
        soma += n;

        while (n != 1) {
            n = nextCollatz(n);
            System.out.print(" → " + n);
            soma += n;
        }

        System.out.println(); // quebra de linha
        return soma;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        if (!sc.hasNextInt()) {
            System.out.println("Erro: A entrada deve ser um número inteiro.");
            return;
        }

        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            return;
        }

        int soma = calculateCollatzSum(n);
        System.out.println("Soma dos termos: " + soma);

        sc.close();
    }
}
