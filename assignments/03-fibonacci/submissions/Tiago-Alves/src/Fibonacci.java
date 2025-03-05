
import java.util.Scanner;

    class Fibonacci {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite um número inteiro não negativo: ");
            int n = scanner.nextInt();
            System.out.println(formatarSaida(calcularFibonacci(n)));
            scanner.close();
        }

        public static long calcularFibonacci(int n) {
            if (n <= 1) {
                return  n;
            }
            long a = 0, b = 1, temp;
            for (int i = 2; i <= n; i++) {
                temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }

        public static String formatarSaida(long resultado) {
            return "O número de Fibonacci é: " + resultado;
        }
    }