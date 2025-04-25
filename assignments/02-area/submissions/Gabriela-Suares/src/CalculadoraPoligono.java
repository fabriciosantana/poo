
import java.util.Scanner;
import java.lang.Math;

public class CalculadoraPoligono {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de lados: ");
        int n = scanner.nextInt();
        System.out.print("Digite o comprimento do lado (m): ");
        double s = scanner.nextDouble();
        scanner.close();

        double area = (n * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / n));
        System.out.printf("A área do polígono é: %.2f metros quadrados\n", area);
    }
}
