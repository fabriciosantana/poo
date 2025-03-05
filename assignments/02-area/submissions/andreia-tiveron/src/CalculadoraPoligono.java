import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();

        double area = calcularArea(n, s);

        System.out.println(formatarSaida(area));

        scanner.close();

    }

    public static double calcularArea(int n, double s){
        return (1.0/4.0)*Math.pow(s,2)*n*(1.0/Math.tan(Math.PI/n));
    }

    public static String formatarSaida(double area){
        return String.format("A área do polígono é: %.2f metros quadrados", area);

    }
}
