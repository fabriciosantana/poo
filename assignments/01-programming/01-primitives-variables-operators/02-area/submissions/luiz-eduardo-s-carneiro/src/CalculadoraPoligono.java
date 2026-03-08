import java.util.Scanner;

public class CalculadoraPoligono{

    public static double calcularArea(int n, double s){

        double area = (1.0/4.0) * Math.pow(s, 2) * n * 1 / (Math.tan(Math.PI/n));
        return area;
    }

    public static String formatarSaida(double area){
        
        String msg = String.format( "A área do polígono é: %.2f metros quadrados", area);
        return msg;
    }

    public static void main(String[] Args){

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();
        System.out.printf("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();

        double area = calcularArea(n, s);

        System.out.println(formatarSaida(area));
    }

}