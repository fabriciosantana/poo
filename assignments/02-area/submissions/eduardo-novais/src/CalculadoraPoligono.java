import java.util.Scanner;
import static java.lang.Math.PI;
import static java.lang.Math.tan;
import static java.lang.Math.pow;

public class CalculadoraPoligono {
    public static void main(String[] args) {
        int numSides;
        double lengthSide, area;

        Scanner input = new Scanner(System.in);

        System.out.printf("Digite o numero de lados do Poligono: ");
        numSides = input.nextInt();

        System.out.printf("Digite o comprimento do lado em metros: ");
        lengthSide = input.nextDouble();

        input.close();

        area = calcularArea(numSides, lengthSide);

        System.out.println(formatarSaida(area));
    }

    public static double calcularArea(int n, double s) {
        return (1.0 / 4.0) * n * pow(s, 2.0) * (1.0 / tan(PI / n));
    }

    public static String formatarSaida(double area) {
        return String.format("A área do polígono é: %.2f metros quadrados", area);
    }
}