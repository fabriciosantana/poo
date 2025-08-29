import java.util.Scanner;
import java.util.Locale;

/**
 * A classe CalculadoraPoligono solicita ao usuário o número de lados e
 * o comprimento do lado de um polígono regular, calcula sua área e
 * exibe o resultado formatado.
 */
public class CalculadoraPoligono {

    /**
     * O método principal (main) é o ponto de entrada do programa.
     * Ele gerencia a entrada de dados do usuário, chama os métodos de cálculo
     * e formatação, e exibe o resultado final no console.
     *
     * @param args Argumentos da linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {
        // Garante que o programa use o ponto (.) como separador decimal para entrada
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        // Solicita e lê o número de lados do polígono
        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();

        // Solicita e lê o comprimento do lado
        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();

        // Fecha o scanner para liberar os recursos
        scanner.close();

        // Chama o método para calcular a área com os valores fornecidos
        double areaCalculada = calcularArea(n, s);

        // Chama o método para formatar a string de saída
        String saidaFormatada = formatarSaida(areaCalculada);

        // Imprime o resultado final no console
        System.out.println(saidaFormatada);
    }

    /**
     * Calcula a área de um polígono regular.
     * A fórmula utilizada é: A = (n * s²) / (4 * tan(π / n))
     *
     * @param n O número de lados do polígono (int).
     * @param s O comprimento de um lado do polígono (double).
     * @return A área calculada do polígono (double).
     */
    public static double calcularArea(int n, double s) {
        // Math.PI representa a constante π
        // Math.tan() calcula a tangente de um ângulo em radianos
        // s * s é o mesmo que s²
        return (n * s * s) / (4.0 * Math.tan(Math.PI / n));
    }

    /**
     * Formata a string de saída para exibir o resultado do cálculo da área.
     *
     * @param area O valor da área a ser formatado.
     * @return Uma String formatada no padrão "A área do polígono é: X.XX metros quadrados".
     */
    public static String formatarSaida(double area) {
        // String.format() é usado para criar uma string formatada.
        // "%.2f" formata o valor double 'area' com duas casas decimais.
        // Usamos Locale.US para garantir que o separador decimal na saída seja um ponto.
        return String.format(Locale.US, "A área do polígono é: %.2f metros quadrados", area);
    }
}