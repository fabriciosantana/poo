import java.util.Scanner;

public class CalcularPoligono{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o número de lados do polígono: ");
        int i = scanner.nextInt();

        System.out.print("Digite o comprimento do escolhido em metros: ");
        double j = scanner.nextDouble();

        double area = calcularArea(i, j);
        String resultado = formatarSaida(area);

        System.out.println(resultado);
        scanner.close();
    }

    public static double calcularArea(int i, double j){
        return (1.0 / 4) * i * j * j / Math.tan(Math.PI / i);
    }
    public static String formatarSaida(double area){
        return String.format("Área do polígono é: %.2f metros quadrados!", area);
    }
}