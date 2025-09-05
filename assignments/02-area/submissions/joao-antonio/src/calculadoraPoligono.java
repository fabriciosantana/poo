import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input the number of sides of the polygon:");
        int n = scanner.nextInt();

        System.out.println("Input the length of one side in meters:");
        double s = scanner.nextDouble();

        scanner.close();

        double area = calculateArea(n, s);

        System.out.printf("The area of the regular polygon is: %.2f square meters\n", area);
    }
    public static double calculateArea(int n, double s) {
        return (n * s * s) / (4 * Math.tan(Math.PI / n));
    }
    public static String formatarSaida(double area) {
        return String.format("%.2f", area);
    }
}
