import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(java.util.Locale.US);

        System.out.printf("Digite o número de lados do polígono: ");
        int n = sc.nextInt();

        System.out.printf("Digite o comprimento do lado em metros: ");
        double s = sc.nextDouble();

        double A = calcularArea(n, s);

        String saida = formatarSaida(A);
        System.out.println(saida);

        sc.close();
    }

    public static double calcularArea(int n, double s){
        return (1.0 / 4.0) * Math.pow(s, 2) * n * (1.0 / Math.tan(Math.PI / n));
    }

    public static String formatarSaida(double A){
        return String.format("A área do polígono é: %.2f metros quadrados", A);
    }
}