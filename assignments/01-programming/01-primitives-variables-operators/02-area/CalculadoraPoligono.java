import java.util.Scanner;
import java.util.Locale;

public class CalculadoraPoligono {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();

        double area = calcularArea(n, s);
        String saida = formatarSaida(area);

        System.out.println(saida);

        scanner.close();
    }
    public static double calcularArea(int n, double s) {
        return (1.0 / 4.0) * s * s * n * (1.0 / Math.tan(Math.PI / n));
    }

    public static String formatarSaida(double area) {
        return String.format("A área do polígono é: %.2f metros quadrados", area);
    }
}