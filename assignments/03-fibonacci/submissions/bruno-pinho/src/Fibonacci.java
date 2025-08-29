import java.util.Scanner;

/**
 * A classe Fibonacci calcula o n-ésimo número da sequência de Fibonacci
 * de forma eficiente, utilizando uma abordagem iterativa.
 */
public class Fibonacci {

    /**
     * O método principal (main) é o ponto de entrada do programa.
     * Ele solicita ao usuário um número, chama os métodos de cálculo e formatação,
     * e exibe o resultado no console.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        scanner.close();

        // Validação para garantir que o número é não negativo
        if (n < 0) {
            System.out.println("Erro: O número deve ser inteiro e não negativo.");
        } else {
            // Chama o método para calcular o n-ésimo número de Fibonacci
            long numeroFibonacci = calcularFibonacci(n);

            // Chama o método para formatar a string de saída
            String saidaFormatada = formatarSaida(numeroFibonacci, n);

            // Imprime o resultado final
            System.out.println(saidaFormatada);
        }
    }

    /**
     * Calcula o n-ésimo número da sequência de Fibonacci usando uma abordagem iterativa.
     * Este método é eficiente e evita a recursão excessiva.
     * F(n) = F(n-1) + F(n-2)
     *
     * @param n A posição na sequência de Fibonacci (um inteiro não negativo).
     * @return O n-ésimo número de Fibonacci como um valor do tipo long.
     */
    public static long calcularFibonacci(int n) {
        // Casos base da sequência
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // Variáveis para armazenar os dois números anteriores da sequência
        long anterior = 0; // F(0)
        long atual = 1;    // F(1)
        long proximo = 1;  // Variável para calcular o próximo número

        // Loop começa em 2, pois os casos 0 e 1 já foram tratados
        for (int i = 2; i <= n; i++) {
            // Calcula o próximo número somando os dois anteriores
            proximo = anterior + atual;
            // Atualiza os valores para a próxima iteração
            anterior = atual;
            atual = proximo;
        }

        return atual;
    }

    /**
     * Formata a string de saída para exibir o resultado do cálculo.
     *
     * @param numeroFibonacci O valor calculado do número de Fibonacci.
     * @param n A posição (n) na sequência.
     * @return Uma String formatada para exibição no console.
     */
    public static String formatarSaida(long numeroFibonacci, int n) {
        // %d é um placeholder para números inteiros (int, long)
        return String.format("O %dº número de Fibonacci é: %d", n, numeroFibonacci);
    }
}