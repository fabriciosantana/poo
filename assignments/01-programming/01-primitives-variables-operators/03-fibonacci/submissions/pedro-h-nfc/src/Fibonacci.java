import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um n\u00FAmero inteiro n\u00E3o negativo: ");
        int n = scanner.nextInt();

        long fibonacci = calcularFibonacci(n);
        System.out.println(formatarSaida(fibonacci, n));
    }

    public static long calcularFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O n\u00FAmero deve ser n\u00E3o negativo.");
        }
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }

        long anterior = 0L;
        long atual = 1L;

        for (int i = 2; i <= n; i++) {
            long proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        return atual;
    }

    public static String formatarSaida(long valor, int n) {
        return "O " + n + "\u00BA n\u00FAmero de Fibonacci \u00E9: " + valor;
    }
}
