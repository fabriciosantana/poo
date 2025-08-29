import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        long resultado = calcularFibonacci(n);

        String saida = formatarSaida(resultado, n);

        System.out.println(saida);

        scanner.close();
    }

    public static long calcularFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0; 
        long b = 1; 
        long fib = 0;

        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }

    public static String formatarSaida(long valor, int n) {
        return String.format("O %dº número de Fibonacci é: %d", n, valor);
    }
}
