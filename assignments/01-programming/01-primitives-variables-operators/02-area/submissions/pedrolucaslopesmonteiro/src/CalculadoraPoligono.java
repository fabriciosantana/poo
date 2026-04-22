import java.lang.Math;
import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o número de lados do polígono: ");
        int n = input.nextInt();

        System.out.println("Digite o comprimento do lado em metros: ");
        double s = input.nextDouble();
        
        double area = calcularArea(n,s);
        String result = formatarSaida(area);
        System.out.println(result);
    }

    public static double calcularArea(int n, double s){
        double area = (1.0 / 4) * Math.pow(s, 2) * n * (1 / Math.tan(Math.PI / n));

        return area;
    }

    public static String formatarSaida(double area) {
        return "A área do polígono é: " +
        String.format("%.2f", area) + " metros quadrados";

    }
}
