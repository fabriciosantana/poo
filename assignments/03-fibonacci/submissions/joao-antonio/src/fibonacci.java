
import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a positive integer number to calculate its Fibonacci sequence: ");
        int n = scanner.nextInt();

        scanner.close();

        System.out.println(formatarSaida(calcularFibonacci(n), n));
    }
    public static long calcularFibonacci(int n) {
        if (n < 2) {
            return n;
        }

        long penultimo = 0; // Representa F(n-2)
        long ultimo = 1;    // Representa F(n-1)
        long atual = 0;
        
        //f(i) = f(i-1) + f(i-2)
        for (int i = 2; i <= n; i++) {
            atual = penultimo + ultimo;
            penultimo = ultimo; // Atualiza F(n-2) para F(n-1)
            ultimo = atual;     // Atualiza F(n-1) para F(n)
        }
        return atual;
    }
    public static String formatarSaida(long result, int n) {
        return String.format("Fibonacci of %d is: %d", n, result);
    }
}
