import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int number = scanner.nextInt();

        System.out.println(formatarSaida(calcularFibonacci(number), number));
    }

    public static long calcularFibonacci(int n) {
        // https://en.wikibooks.org/wiki/Algorithm_Implementation/Mathematics/Fibonacci_Number_Program
        if (n < 2) return n;

        return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
    }

    public static String formatarSaida(long result, int number) {
        return String.format("O %dº número de Fibonacci é: %d", number, result);
    }
}