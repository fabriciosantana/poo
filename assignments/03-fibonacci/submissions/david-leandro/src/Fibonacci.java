import java.util.Scanner;

public class Fibonacci {

    // método main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // entrada do usuário
        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        // cálculo do Fibonacci
        long resultado = calcularFibonacci(n);

        // saída formatada
        String saida = formatarSaida(resultado, n);
        System.out.println(saida);

        scanner.close();
    }

    // método para calcular o n-ésimo Fibonacci (abordagem iterativa eficiente)
    public static long calcularFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0, b = 1, fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }

    // método para formatar a saída
    public static String formatarSaida(long resultado, int n) {
        return String.format("O %dº número de Fibonacci é: %d", n, resultado);
    }
}
