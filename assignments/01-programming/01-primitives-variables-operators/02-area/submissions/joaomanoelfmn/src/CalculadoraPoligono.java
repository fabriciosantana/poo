import java.util.Scanner;
import java.lang.Math;

public class CalculadoraPoligono {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();

        double A = calcularArea(n, s);
        String formatar = formatarSaida(A);

        System.out.printf(formatar);

        scanner.close();
    }

    public static double calcularArea(int n, double s){
        return 1.0/4 * (s*s)*n * (1.0/Math.tan(Math.PI/n));
    }

public static String formatarSaida(double A){
        if (A >= 1.0){
            return String.format(java.util.Locale.US, "A área do polígono é: %.2f metros quadrados", A);
        } else {
            return String.format(java.util.Locale.US, "A área do polígono é: %.2f centímetros quadrados", A);
        }
    }

}
