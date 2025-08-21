import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = input.nextInt();

        long resultadoFibonacci = calcularFibonacci(n);

        String saida = formatarSaida(resultadoFibonacci, n);
        System.out.println(saida);

        input.close();
    }

    public static long calcularFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long fibAnterior = 0;
        long fibAtual = 1;

        for (int i = 2; i <= n; i++) {
            long proximoFib = fibAnterior + fibAtual;
            fibAnterior = fibAtual;
            fibAtual = proximoFib;
        }

        return fibAtual;
    }

    public static String formatarSaida(long resultado, int n) {
        return String.format("O %dº número de Fibonacci é: %d", n, resultado);
    }
}
