  import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // Solicita ao usuário o número n
        while (true) {
            System.out.print("Digite um número inteiro não negativo: ");
            n = scanner.nextInt();

            // Verifica se n é negativo
            if (n < 0) {
                System.out.println("Por favor, insira um número não negativo.");
            } else {
                break; // Se o número não for negativo, sai do loop
            }
        }

        // Calcula o n-ésimo número de Fibonacci
        long fibonacci = calcularFibonacci(n);

        // Formata a saída e imprime o resultado
        String resultado = formatarSaida(fibonacci, n);
        System.out.println(resultado);

        scanner.close();
    }

    // Método para calcular o n-ésimo número de Fibonacci de forma iterativa
    public static long calcularFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

    // Método para formatar a saída de acordo com o número de Fibonacci
    public static String formatarSaida(long fibonacci, int n) {
        return "O " + n + "º número de Fibonacci é: " + fibonacci;
    }
}
