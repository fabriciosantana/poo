import java.util.Scanner;

public class CalculadoraPoligono {

    // Método principal: ponto de entrada do programa
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Leitura de entradas
        System.out.print("Digite o número de lados do polígono: ");
        int n = entrada.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = entrada.nextDouble();

        // Cálculo da área
        double area = calcularArea(n, s);

        // Exibição do resultado formatado
        String resultado = formatarSaida(area);
        System.out.println(resultado);

        entrada.close();
    }

    // Método para calcular a área de um polígono regular
    public static double calcularArea(int n, double s) {
        // Fórmula: (1/4) * n * s^2 * (1 / tan(π/n))
        return (n * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / n));
    }

    // Método para formatar a saída do resultado
    public static String formatarSaida(double area) {
        return String.format("A área do polígono é: %.2f metros quadrados", area);
    }
}
