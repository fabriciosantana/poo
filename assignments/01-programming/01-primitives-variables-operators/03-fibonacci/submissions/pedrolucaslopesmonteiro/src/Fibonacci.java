import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite um número inteiro não negativo: ");
        int n = input.nextInt();
        while (n<0) {
            System.out.println("O número digitado é negativo.");
            System.out.println("Digite um número inteiro não negativo: ");
            n = input.nextInt();
        }
        
        long fibonacci = calcularFibonacci(n);
        String result = formatarSaida(fibonacci,n);
        System.out.println(result);

    }

    public static long calcularFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long anterior = 0;
        long atual = 1;

        for (int i = 2; i <= n; i++) {
            long proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        return atual;

    }
    
    public static String formatarSaida(long resultado, int n) {

        return "O " + n + "º número de Fibonacci é: " + resultado;
    }

    
}
