
import java.util.Scanner;

public class CalculadoraPoligono{

    // Método para calcular área de um poligono 
    public static double calcularArea(int n, double s) {
        return (n * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / n));
    }

    // Método para formatar a saída 
    public static String formatarSaida(double area) {
        return String.format("A área do polígono é: %.2f metros quadrados", area);
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o número de lados do polígono: ");
        int n = leitor.nextInt();

        System.out.print("Digite o comprimento do lado em metros:  ");
        double s = leitor.nextDouble();

        double area = calcularArea(n, s);

        String resultado = formatarSaida(area);

        System.out.println(resultado);
    

        leitor.close();
    }
}
