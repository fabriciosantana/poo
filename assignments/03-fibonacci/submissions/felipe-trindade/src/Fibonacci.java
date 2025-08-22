import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(java.util.Locale.US);

        System.out.printf("Digite um número inteiro não negativo: ");
        int n = sc.nextInt();

        long F = calcularFibonacci(n);

        String saida = formatarSaida(F, n);
        System.out.println(saida);

        sc.close();
    }

    public static long calcularFibonacci(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        long a = 0, b = 1, c = 0;
        
        for(int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    
    public static String formatarSaida(long F, int n){
        return String.format("O %dº número de Fibonacci é: %d", n, F);
    }
}