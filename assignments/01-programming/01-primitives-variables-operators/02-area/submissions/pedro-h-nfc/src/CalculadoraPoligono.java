import java.util.Locale;
import java.util.Scanner;

public class CalculadoraPoligono {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Digite o n\u00FAmero de lados do pol\u00EDgono: ");
        int numeroLados = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double comprimentoLado = scanner.nextDouble();

        double area = calcularArea(numeroLados, comprimentoLado);
        System.out.println(formatarSaida(area));
    }

    public static double calcularArea(int n, double s) {
        if (n < 3 || s <= 0) {
            throw new IllegalArgumentException(
                "N\u00FAmero de lados deve ser >= 3 e comprimento do lado deve ser positivo."
            );
        }

        return 0.25 * s * s * n * (1.0 / Math.tan(Math.PI / n));
    }

    public static String formatarSaida(double area) {
        return String.format(Locale.US, "A \u00E1rea do pol\u00EDgono \u00E9: %.2f metros quadrados", area);
    }
}
