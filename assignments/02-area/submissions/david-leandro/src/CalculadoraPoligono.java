public import java.util.Scanner;

public class CalculadoraPoligono {

    // método main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // entrada do usuário
        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();

        // cálculo da área
        double area = calcularArea(n, s);

        // saída formatada
        String resultado = formatarSaida(area);
        System.out.println(resultado);

        scanner.close();
    }

    // método que calcula a área do polígono regular
    public static double calcularArea(int n, double s) {
        return (n * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / n));
    }

    // método que formata a saída
    public static String formatarSaida(double area) {
        return String.format("A área do polígono é: %.2f metros quadrados", area);
    }
}
 calculo-de-area {
    
}
