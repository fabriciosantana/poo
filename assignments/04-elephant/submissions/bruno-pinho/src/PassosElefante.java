import java.util.Scanner;

/**
 * A classe PassosElefante calcula o número mínimo de passos que um elefante
 * precisa para ir da posição 0 até uma posição x, podendo dar passos de
 * tamanho 1, 2, 3, 4 ou 5.
 */
public class PassosElefante {

    /**
     * O método principal (main) é o ponto de entrada do programa.
     * Ele solicita a posição do amigo, valida a entrada, chama os métodos
     * de cálculo e formatação, e exibe o resultado.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();

        scanner.close();

        // Requisito: Validar se x está dentro do intervalo permitido (1 <= x <= 1.000.000)
        if (x >= 1 && x <= 1_000_000) {
            // Chama o método para calcular o número mínimo de passos
            int passosMinimos = calcularPassosMinimos(x);

            // Chama o método para formatar a string de saída
            String saidaFormatada = formatarSaida(passosMinimos);

            // Imprime o resultado final no console
            System.out.println(saidaFormatada);
        } else {
            // Exibe uma mensagem de erro se a entrada for inválida
            System.out.println("Erro: A posição deve ser um número inteiro entre 1 e 1.000.000.");
        }
    }

    /**
     * Calcula o número mínimo de passos para alcançar a posição x.
     * A estratégia ótima é usar o maior passo possível (tamanho 5) o máximo de vezes.
     *
     * @param x A posição de destino (um inteiro positivo).
     * @return O número mínimo de passos necessários (int).
     */
    public static int calcularPassosMinimos(int x) {
        // A lógica é dividir a distância total pelo maior passo possível (5).
        // Se houver um resto na divisão, significa que mais um passo é necessário
        // para cobrir a distância restante (que será de 1, 2, 3 ou 4).
        // A função Math.ceil(a / b) faz exatamente isso: calcula a divisão e
        // arredonda o resultado para o próximo número inteiro.

        // Exemplo 1: x = 12
        // (double) 12 / 5.0 = 2.4
        // Math.ceil(2.4) = 3.0. O resultado é 3 passos. (5, 5, 2)

        // Exemplo 2: x = 10
        // (double) 10 / 5.0 = 2.0
        // Math.ceil(2.0) = 2.0. O resultado é 2 passos. (5, 5)

        return (int) Math.ceil((double) x / 5.0);
    }

    /**
     * Formata a string de saída para exibir o resultado do cálculo.
     *
     * @param passos O número de passos calculado.
     * @return Uma String formatada para exibição no console.
     */
    public static String formatarSaida(int passos) {
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }
}