import java.util.Scanner;

public class Fibonacci{
    public static void main(String[] Args){

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        long fibonacci = calcularFibonacci(n);

        System.out.println(formatarSaida(fibonacci, n));
    }

    public static long calcularFibonacci(int n){

        if (n <= 1){
            return n;
        }

        return calcularFibonacci(n-1) + calcularFibonacci(n-2);
    }

    public static String formatarSaida(long fibonacci, int n){

        return "O " + n + "º número de Fibonacci é: " + fibonacci;
    }
}