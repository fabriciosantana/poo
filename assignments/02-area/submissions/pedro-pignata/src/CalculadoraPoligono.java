
import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de lados do polígono: ");
        double numero = scanner.nextDouble();

        System.out.println("Digite o comprimento do lado em metros: ");
        double comprimento = scanner.nextDouble();

        double area = calcularArea(numero, comprimento);
        String resultado = formatarSaida(area);

        System.out.println(resultado);
    }

    public static double calcularArea(double numero, double comprimento){
        return (numero * Math.pow(comprimento, 2)) / (4 * Math.tan(Math.PI / numero));
    }

    public static String formatarSaida(double area){
        return String.format ("A área do polígono é: %.2f metros quadrados", area);
    }   
}