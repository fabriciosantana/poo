import java.util.Scanner;
import static java.lang.Math.PI;
import static java.lang.Math.tan;

class CalculadoraPoligono{

    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        double area, s;
        int n;

        System.out.print("Digite o número de lados do polígono: ");
        n = ler.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        s = ler.nextDouble();

        // chamada da função para calcular a área
        area = CalcularArea(n, s);

        // chama função para formatar a saída
        String area_formatada = FormatarSaida(area);

        System.out.println("A área do polígono é: " + area_formatada + " metros quadrados");

        ler.close();
    }

    public static double calcularArea(int n, double s){
        double area = ((1.0/4.0) * (s * s) * n * (1.0 / tan(PI / n)));
        return area; 
    }

    public static String formatarSaida (double area){
        String area_formatada = String.format("%.2f", area);
        return area_formatada;
    }
}

// A = 1/4 * (s*s) * n * (1/tan(PI/n))
// n = n de lados; s = compimento do lado; 