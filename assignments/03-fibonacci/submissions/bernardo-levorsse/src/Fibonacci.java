import java.util.Scanner;

public class Fibonacci {

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        // Cálculo do n-ésimo Fibonacci
        long fib = calcularFibonacci(n);

        // Saída formatada
        String resultado = formatarSaida(fib, n);
        System.out.println(resultado);

        scanner.close();
    }

    // Método para calcular o n-ésimo número de Fibonacci (iterativo -> eficiente)
    public static long calcularFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // Método para formatar a saída
    public static String formatarSaida(long valor, int n) {
        return String.format("O %dº número de Fibonacci é: %d", n, valor);
    }
}
