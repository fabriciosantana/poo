
import java.util.Scanner;

public class Fibonacci {
    
    public static long calcularFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        
        long anterior = 0;  
        long atual = 1; 
        long proximo;
        
        for (int i = 2; i <= n; i++) {
            proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }
        
        return atual;
    }
    
    public static String formatarSaida(long fibonacci, int n) {
        return "O " + n + "º número de Fibonacci é: " + fibonacci;
    }

       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();
        
        long resultado = calcularFibonacci(n);
        String saida = formatarSaida(resultado, n);
        
        System.out.println(saida);
        
        scanner.close();
    }
}