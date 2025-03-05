import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        scanner.close();

        long resultado = calcularFibonacci(n);
        String resposta = formatarSaida(resultado, n);
        
        System.out.println(resposta);  
        }

        public static long calcularFibonacci(int n) {
            if (n <=1) {
                return n;
            } else {
                long a = 0;
                long b = 1;
                long soma = 0;
                for (int i = 2; i <= n; i++) {
                    soma = a + b;
                    a = b;
                    b = soma;
                }
                return b;
            }
        }

        public static String formatarSaida(long resultado, int n) {
            return String.format("O %dº número de Fibonacci é: %d", n, resultado);
        }
    }
