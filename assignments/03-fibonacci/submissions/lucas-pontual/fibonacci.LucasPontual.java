import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        long fibonacciNumber = calcularFibonacci(n);
        String saidaFormatada = formatarSaida(n, fibonacciNumber);

        System.out.println(saidaFormatada);

        scanner.close();
    }

    public static long calcularFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0;
        long b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static String formatarSaida(int n, long fibonacciNumber) {
        return String.format("O %dº número de Fibonacci é: %d", n, fibonacciNumber);
    }
}


