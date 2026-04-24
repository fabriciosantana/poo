import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o termo desejado da sequência de Fibonacci: ");
        int n = ler.nextInt();
        if (n < 0) {
            System.out.println("Por favor, insira um número inteiro não negativo.");
        } else {
            long resultado = calcularFibonacci(n);
            String saida = formatarSaida(resultado, n);
            System.out.println(saida);
        }

    }

    public static long calcularFibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
        }
    }

    public static String formatarSaida(long resultado, int n) {
        return String.format("O %dº termo da sequência de Fibonacci é: %d", n, resultado);
    }
}
