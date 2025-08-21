import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Número inválido. Deve ser não negativo.");
            scanner.close();
            return;
        }

        long resultado = calcularFibonacci(n);              // cálculo eficiente
        String saida = formatarSaida(resultado, n);          // formatação conforme especificação

        System.out.println(saida);

        scanner.close();
    }

    // Cálculo eficiente (iterativo)
    public static long calcularFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0, b = 1, soma = 0;
        for (int i = 2; i <= n; i++) {
            soma = a + b;
            a = b;
            b = soma;
        }
        return b;
    }

    // Formata saída (resultado primeiro, depois n)
    public static String formatarSaida(long resultado, int n) {
        return String.format("O %dº número de Fibonacci é: %d", n, resultado);
    }
}
