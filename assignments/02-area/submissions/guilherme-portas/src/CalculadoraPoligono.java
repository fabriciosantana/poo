import java.util.Scanner;
import java.lang.Math;

public class CalculadoraPoligono {
    public static Double calcularArea (int n, double s) {
        float pi = 3.14159f;
        double a = 1D/4 * s * s * n * 1/Math.tan(pi/n);
        return a;
    }

    public static String formatarSaida (double a) {
        return "A área do polígono é: " + a + " metros quadrados";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();

        double a = calcularArea(n, s);
        System.out.println(formatarSaida(a));

        scanner.close();
    }
}