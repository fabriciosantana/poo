import java.util.Locale;
import java.util.Scanner;

public class CalculadoraPoligono {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        // entrada nao numerica vira 0 e cai na validacao
        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.hasNextInt() ? scanner.nextInt() : 0;
        if (n < 3) {
            System.out.println("Número de lados inválido: informe um inteiro maior ou igual a 3.");
            scanner.close();
            return;
        }

        // isFinite barra NaN e Infinity, que o Scanner aceita
        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.hasNextDouble() ? scanner.nextDouble() : 0;
        if (!Double.isFinite(s) || s <= 0) {
            System.out.println("Comprimento inválido: informe um número maior que zero.");
            scanner.close();
            return;
        }
        scanner.close();

        System.out.println(formatarSaida(calcularArea(n, s)));
    }

    public static double calcularArea(int n, double s) {
        return 0.25 * s * s * n / Math.tan(Math.PI / n);
    }

    public static String formatarSaida(double area) {
        return String.format(Locale.US, "A área do polígono é: %.2f metros quadrados", area);
    }
}
