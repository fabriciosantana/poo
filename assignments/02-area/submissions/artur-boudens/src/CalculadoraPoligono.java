import java.util.Locale;
import java.util.Scanner;

public class CalculadoraPoligono {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();

        scanner.close();

        double area = calcularArea(n, s);
        String saidaFormatada = formatarSaida(area);

        System.out.println(saidaFormatada);
    }

    public static double calcularArea(int n, double s) {
        return (0.25 * n * s * s) / Math.tan(Math.PI / n);
    }

    public static String formatarSaida(double area) {
        return String.format(Locale.US, "A área do polígono é: %.2f metros quadrados", area);
    }
}