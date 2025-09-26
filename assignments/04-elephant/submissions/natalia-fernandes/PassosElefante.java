import java.util.Scanner;

public class PassosElefante {

    // Método principal
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo (1 a 1000000): ");
        int x = entrada.nextInt();

        // Validação do intervalo
        if (x < 1 || x > 1_000_000) {
            System.out.println("Entrada inválida. O valor de x deve estar entre 1 e 1.000.000.");
            entrada.close();
            return;
        }

        int passos = calcularPassosMinimos(x);
        String saida = formatarSaida(passos);
        System.out.println(saida);

        entrada.close();
    }

    /**
     * Calcula o número mínimo de passos para chegar a x,
     * podendo dar passos de tamanho 1..5.
     * Fórmula: ceil(x / 5.0) == x / 5 + (x % 5 == 0 ? 0 : 1)
     */
    public static int calcularPassosMinimos(int x) {
        return x / 5 + (x % 5 == 0 ? 0 : 1);
    }

    // Formata a mensagem de saída
    public static String formatarSaida(int passos) {
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }
}
