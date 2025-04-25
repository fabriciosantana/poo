import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();
        System.out.println("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();
        scanner.close();
        double area = calcularArea(n, s);
        String areaFormatada = formatarSaida(area);
        System.out.println(areaFormatada);
    }
    public static String formatarSaida (double area){
        return "A área do polígono é: " + area + " metros quadrados";
    }

    public static Double calcularArea(int n, Double s){
        return ((s*s)/4)*(n/(Math.tan(Math.PI/n)));
    }
}
