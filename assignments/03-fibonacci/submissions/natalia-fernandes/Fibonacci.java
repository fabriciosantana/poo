import java.util.Scanner;

public class Fibonacci {

    // Método principal
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Entrada do usuário
        System.out.print("Digite um número inteiro não negativo: ");
        int n = entrada.nextInt();

        // Cálculo do n-ésimo número de Fibonacci
        long resultado = calcularFibonacci(n);

        // Exibição da saída formatada
        String saida = formatarSaida(n, resultado);
        System.out.println(saida);

        entrada.close();
    }

    // Método para calcular Fibonacci de forma eficiente (iterativa)
    public static long calcularFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long anterior = 0;
        long atual = 1;
        long proximo = 0;

        for (int i = 2; i <= n; i++) {
            proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        return atual;
    }

    // Método para formatar a saída
    public static String formatarSaida(int n, long valor) {
        return String.format("O %dº número de Fibonacci é: %d", n, valor);
    }
}
