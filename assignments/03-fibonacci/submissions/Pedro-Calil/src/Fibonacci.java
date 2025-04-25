import java.util.Scanner;

public class Fibonacci {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();
        
        if (n < 0) {
            System.out.println("Por favor, insira um número não negativo.");
            return;
        }
        
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
        long temp;
        
        for (int i = 2; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        
        return b;
    }
    
    public static String formatarSaida(long fibonacciNumber, int n) {
        return "O " + n + "º número de Fibonacci é: " + fibonacciNumber;
    }
}