import java.util.Scanner;

public class CalculadoraPoligono {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();

        // Cálculo da área
        double area = calcularArea(n, s);

        // Saída formatada
        System.out.println(formatarSaida(area));

        scanner.close();
    }

    // Método para calcular a área do polígono regular
    public static double calcularArea(int n, double s) {
        return (n * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / n));
    }

    // Método para formatar a saída
    public static String formatarSaida(double area) {
        return String.format("A área do polígono é: %.2f metros quadrados", area);
    }
}
