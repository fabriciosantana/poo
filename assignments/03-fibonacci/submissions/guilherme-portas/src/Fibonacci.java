import java.util.Scanner;

public class Fibonacci {
    public static long calcularFibonacci (int n) {
        if (n < 2)
            return n;
        else
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
    }

    public static String formatarSaida (long f, int n) {
        return "O " + n + "º número de Fibonacci é: " + f;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();
        if (n < 0) {
            scanner.close();
            throw new java.lang.Error("Número inteiro digitado é negativo");
        }

        System.out.println(formatarSaida(calcularFibonacci(n), n));

        scanner.close();
    }
}
