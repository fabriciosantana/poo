import java.util.Scanner;

public class CalculadoraPoligono {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();
        
        System.out.println("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();

        double area = calcularArea(n, s);
        String resultado = formatarSaida(area);
        System.out.println(resultado);

        scanner.close();
    }

    public static double calcularArea(int n, double s) {
        return (n * (s * s)) / (4 * Math.tan(Math.PI / n));
    }

    public static String formatarSaida(double area) {
        return String.format("A área do polígono é: " + area + " metros quadrados");
    }
}
