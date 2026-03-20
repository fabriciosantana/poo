import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int n = sc.nextInt();

        long Fibonacci = calcularFibonacci(n);

        String resultado = formatarSaida(Fibonacci, n);

        System.out.println(resultado);

        sc.close();
    }

        public static long calcularFibonacci ( int n){
            if (n == 0) return 0;
            if (n == 1) return 1;

           long anterior2 = 0;
           long anterior1 = 1;
           long atual = 0;

            for (int i = 2; i <= n; i++) {
                atual = anterior1 + anterior2;
                anterior2 = anterior1;
                anterior1 = atual;
            }
            return atual;
        }
        public static String formatarSaida ( long Fibonacci, int n){
            return "O " + n + "º número de Fibonacci é: " + Fibonacci;
        }
}