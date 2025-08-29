import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int n;

        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite um número inteiro não negativo: ");
        n = input.nextInt();

        long resultado = calcularFibonacci(n);
        System.out.println(formatarSaida(resultado, n));
    }

    public static long calcularFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0;
        long b = 1;
        long c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    public static String formatarSaida(long fibonacci, int n) {
        return String.format("O %dº número de Fibonacci é: %d", n, fibonacci);
    }
}
