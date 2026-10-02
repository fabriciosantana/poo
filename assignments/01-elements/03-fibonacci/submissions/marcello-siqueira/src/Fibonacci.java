import java.util.Scanner;

public class Fibonacci {

    // F(93) ja nao cabe em long
    private static final int MAIOR_N = 92;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // entrada nao numerica vira -1 e cai na mesma validacao de intervalo
        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.hasNextInt() ? scanner.nextInt() : -1;
        scanner.close();
        if (n < 0 || n > MAIOR_N) {
            System.out.println("Número inválido: informe um inteiro entre 0 e " + MAIOR_N + ".");
            return;
        }

        System.out.println(formatarSaida(calcularFibonacci(n), n));
    }

    public static long calcularFibonacci(int n) {
        long anterior = 0;
        long atual = 1;
        for (int i = 0; i < n; i++) {
            long proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }
        return anterior;
    }

    public static String formatarSaida(long valor, int n) {
        return "O " + n + "º número de Fibonacci é: " + valor;
    }
}
