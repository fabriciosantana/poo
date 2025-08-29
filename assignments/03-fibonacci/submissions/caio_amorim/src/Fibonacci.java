import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro não negativo: ");
        try {
            int n = scanner.nextInt();
            long resultado = calcularFibonacci(n);
            String saida = formatarSaida(resultado, n);
            System.out.println(saida);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro não negativo.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static long calcularFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O número deve ser não negativo.");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long a = 0;
        long b = 1;
        long c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public static String formatarSaida(long fibonacciNumber, int n) {
        return String.format("O %dº número de Fibonacci é: %d", n, fibonacciNumber);
    }
}
