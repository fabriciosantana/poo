import java.util.Scanner;


public class CalculadoraPoligono {
    public static double calcularArea(int n, double s) {
        double area = (n * (s * s)) / (4 * Math.tan(Math.PI / n));
        return area;
    }

    public static String formatarSaida(double area) {
        String areaFormatada = String.format("%.2f", area);
        return areaFormatada;
    }
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o número de lados do polígono: ");
        int n = input.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = input.nextDouble();

        double area = calcularArea(n, s);

        String areaFormatada = formatarSaida(area);

        System.out.println("A área do polígono é: " + areaFormatada + " metros quadrados.");
    }

   

    
}
