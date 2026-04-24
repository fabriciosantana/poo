import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Erro, o número deve ser um inteiro não negativo.");
            scanner.close();
            return;
0
        } else {

            long resultado = calcularFibonacci(n);
            String saida = formatarSaida(n, resultado);
            System.out.println(saida);
            scanner.close();
                
        }


        
    }


    public static long calcularFibonacci(int n) {
        
        if (n == 0 || n == 1) {
            return 1;
        }
        
        long a = 0, b = 1;
        
        for (int i = 2; i <= n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return b;
    
    }

    public static String formatarSaida(int n, long resultado) {
    
            return "O " + n + "º número de Fibonacci é: " + resultado;
    }
}
