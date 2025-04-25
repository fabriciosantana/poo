import java.util.Scanner;

public class Fibonacci {
    public static void main (String[] args){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        long resultado = calcularFibonacci(n);
        String saidaFormatada = formatarSaida(resultado, n);
        System.out.println(saidaFormatada);
    }

    public static long calcularFibonacci(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;

        long fibAnterior = 0;
        long fibAtual = 1;
        for (int i = 2; i <= n; i++){
            long fibNext = fibAnterior + fibAtual;
            fibAnterior = fibAtual;
            fibAtual = fibNext;
          }
          return fibAtual;
     }

     public static String formatarSaida(long fibonacci, int n){
        return "O " + n + "}º número de Fibonacci é: " + fibonacci;
     }
}

