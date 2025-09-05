package Lucas_Pontual.src.fibonacci;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Erro: O número deve ser não negativo.");
        } else {
            long fibonacciNumber = calcularFibonacci(n);
            System.out.println(formatarSaida(fibonacciNumber, n));
        }

        scanner.close();
    }

    public static long calcularFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0;
        long b = 1;
        for (int i = 2; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

    public static String formatarSaida(long fibonacciNumber, int n) {
        return String.format("O %dº número de Fibonacci é: %d", n, fibonacciNumber);
    }
}


