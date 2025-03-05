
import java.util.Scanner;

class CalculadoraPoligono {
    public  static void main(
        String[] args
    ) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();
        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();
        double area = calcularArea(n, s);
        System.out.println(formatarSaida(area));
        scanner.close();
    }

    public static double calcularArea(
        int numeroLados, double comprimentoLados
    ) {
        return (numeroLados * Math.pow(comprimentoLados, 2) / (4 * Math.tan(Math.PI / numeroLados)));
    }

    public static String formatarSaida(double area) {
        return String.format("A área do polígono é: %.2f metros quadrados", area);
    }
}