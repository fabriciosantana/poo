import java.util.Scanner;

/*public class CalculadoraPoligono {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número de lados do polígono: ");
        int n = sc.nextInt();
        System.out.println("Digite o comprimento do lado em metros ");
        double s = sc.nextDouble();

        area = calcularArea(n, s)
        resultado = formatarSaida(area)
        System.out.println(resultado);
    }*/
public class CalculadoraPoligono {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número de lados do polígono (m):");
        int n = sc.nextInt();
        System.out.println("Digite o comprimento do lado em metros:");
        double s = sc.nextDouble();
        double area = calcularArea(n, s);
        String resultado = formatarSaida(area);
        System.out.println(resultado);
        sc.close();
    }
    public static double calcularArea (int n, double s) {
        double area = (1.0 / 4) * (s * s) * n * (1 / Math.tan(Math.PI / n));
                return area;
    }
    public static String formatarSaida(double area) {
        return "A área do polígono é: " + area + " metros quadrados";
    }

}